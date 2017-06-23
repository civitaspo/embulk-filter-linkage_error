Embulk::JavaPlugin.register_filter(
  "linkage_error", "org.embulk.filter.linkage_error.LinkageErrorFilterPlugin",
  File.expand_path('../../../../classpath', __FILE__))
