package jib.builder;

import com.google.cloud.tools.jib.api.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Image {
    public void build(Args args) {
        try {
            Containerizer img;
            if(args.getType() == "registry") {
                //RegistryImage docImg = RegistryImage.named(args.getToImage())
                System.out.println(args.getUser());
                System.out.println(args.getPassword());
                img = Containerizer.to(RegistryImage.named(args.getToImage()).addCredential(args.getUser(), args.getPassword()));

            }else {
                //DockerDaemonImage docImg = DockerDaemonImage.named(args.getToImage());
                img = Containerizer.to(DockerDaemonImage.named(args.getToImage()));
            }

            System.out.println(args);
            Jib.from(args.getFromImage())
                    .addLayer(Arrays.asList(Paths.get(args.getSrc())), AbsoluteUnixPath.get(args.getDst()))
                    .setEntrypoint(args.getEntryPoint())
                    .containerize(img);
        } catch (InterruptedException | InvalidImageReferenceException | ExecutionException | CacheDirectoryCreationException | IOException | RegistryException e) {
            e.printStackTrace();
        }
    }
}
