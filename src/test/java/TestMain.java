import com.github.luben.zstd.ZstdInputStreamNoFinalizer;
import io.github.gaming32.smbwle.byml.BymlReader;
import io.github.gaming32.smbwle.byml.BymlWriter;
import io.github.gaming32.smbwle.byml.node.*;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestMain {
    private static final String TEST_PATH = "E:\\SwitchDumps\\SMBWonder\\romfs\\BancMapUnit\\Course001_Main.bcett.byml.zs";

    public static void main(String[] args) throws IOException {
        final BymlCollection value = new BymlHash(Map.of(
            "Hello", BymlString.valueOf("World"),
            "Banana", new BymlArray(List.of(
                BymlInt.valueOf(35),
                BymlUInt64.valueOf(BymlUInt64.ULONG_MAX)
            ))
        ));

        try (final FileSystem fs = FileSystems.newFileSystem(Path.of("test.zip"), Map.of("create", true))) {
            final Path testPath = fs.getPath("test.byml");

            try (SeekableByteChannel channel = Files.newByteChannel(
                testPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
            )) {
                BymlWriter.write(value, channel);
            }

            final BymlCollection readValue = BymlReader.read(Files.readAllBytes(testPath));
            System.out.println("Equals: " + readValue.equals(value));
            System.out.println(readValue);
        }
    }

    public static void mainOld(String[] args) throws IOException {
        final byte[] value;
        try (InputStream is = new ZstdInputStreamNoFinalizer(Files.newInputStream(Path.of(TEST_PATH)))) {
            value = is.readAllBytes();
        }
        System.out.println("In size: " + value.length);
        final BymlCollection data = BymlReader.read(value);
//        try (SeekableByteChannel out = Files.newByteChannel(
//            Path.of("output-test.byml"),
//            StandardOpenOption.CREATE,
//            StandardOpenOption.WRITE,
//            StandardOpenOption.TRUNCATE_EXISTING
//        )) {
//            BymlWriter.write(data, out);
//        }
        final SeekableInMemoryByteChannel out = new SeekableInMemoryByteChannel();
        BymlWriter.write(data, out, 7);
        System.out.println("Out size: " + out.size());
        final byte[] newBinary = Arrays.copyOf(out.array(), (int)out.size());
        System.out.println("Mismatch: " + Arrays.mismatch(value, newBinary));

        final BymlCollection newData = BymlReader.read(newBinary);
        System.out.println("Equals: " + data.equals(newData));

        Files.writeString(Path.of("original.txt"), data.toString());
        Files.writeString(Path.of("reparsed.txt"), newData.toString());
    }
}
