package org.embulk.filter.linkage_error;

import org.embulk.config.ConfigSource;
import org.embulk.config.Task;
import org.embulk.config.TaskSource;
import org.embulk.spi.FilterPlugin;
import org.embulk.spi.PageOutput;
import org.embulk.spi.Schema;
import org.embulk.spi.json.JsonParser;
import org.msgpack.value.Value;

public class LinkageErrorFilterPlugin
        implements FilterPlugin
{
    public interface PluginTask
            extends Task
    {
    }

    @Override
    public void transaction(ConfigSource config, Schema inputSchema,
            FilterPlugin.Control control)
    {
        PluginTask task = config.loadConfig(PluginTask.class);

        Schema outputSchema = inputSchema;

        JsonParser jsonParser = new JsonParser();
        Value v = jsonParser.parse("{}");

        v.asMapValue().map(); // throw here

        control.run(task.dump(), outputSchema);
    }

    @Override
    public PageOutput open(TaskSource taskSource, Schema inputSchema,
            Schema outputSchema, PageOutput output)
    {
        PluginTask task = taskSource.loadTask(PluginTask.class);

        // Write your code here :)
        throw new UnsupportedOperationException("LinkageErrorFilterPlugin.open method is not implemented yet");
    }
}
