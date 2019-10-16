package jib.builder;

import com.beust.jcommander.Parameter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Args {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-src", "--source-dir" }, description = "Source dir from which the files are copied to image", required = true)
    private String src;

    @Parameter(names = { "-from", "--from-image" }, description = "From image", required = true)
    private String fromImage;

    @Parameter(names = { "-to", "--to-image" }, description = "To image, format image:tag", required = true)
    private String toImage;

    @Parameter(names = { "-e", "--entry-point" }, description = "Entry point for the image -e cmd1, cmd2 cmd3", required = true)
    private List<String> entryPoint = new ArrayList<>();

    @Parameter(names = { "-dst", "--destination-dir" }, description = "where should be the files places by default copies to /")
    private String dst = "/";


    public List<String> getParameters() {
        return parameters;
    }

    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    public String getFromImage() {
        return fromImage;
    }

    public String getToImage() {
        return toImage;
    }

    public List<String> getEntryPoint() {
        return entryPoint;
    }
}