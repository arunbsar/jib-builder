package jib.builder;

import com.google.cloud.tools.jib.api.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Image {
    public void build(Args args) {
        try {

            DockerDaemonImage docImg = DockerDaemonImage.named(args.getToImage());
            Jib.from(args.getFromImage())
                    .addLayer(Arrays.asList(Paths.get(args.getSrc())), AbsoluteUnixPath.get(args.getDst()))
                    .setEntrypoint(args.getEntryPoint())
                    .containerize(
                            Containerizer.to(docImg));
        } catch (InterruptedException | InvalidImageReferenceException | ExecutionException | CacheDirectoryCreationException | IOException | RegistryException e) {
            e.printStackTrace();
        }
    }
}
