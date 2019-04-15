package com.tan.nioexample.application.heartbeat;

public class Runner {
	  private Runner() {
	        throw new IllegalStateException(Constants.INSTANTIATION_NOT_ALLOWED);
	    }

	    public static void main(final String... args) {
	        CLIConfigurator.configure(args).ifPresent(cliConfig -> Mode.valueOf(cliConfig.getMode()).execute(cliConfig));
	    }

}
