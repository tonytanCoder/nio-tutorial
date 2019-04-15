package com.tan.nioexample.application.heartbeat;

import java.util.Objects;

import org.apache.commons.cli.CommandLine;

public class CLIConfig {
	  private final String networkInterfaceName;
	    private final String mode;
	    private final String serviceId;

	    CLIConfig(final CommandLine commandLine) {
	        assert !Objects.isNull(commandLine);

	        this.networkInterfaceName = commandLine.getOptionValue(CLIConfigurator.NETWORK_INTERFACE_NAME_SYMBOL);
	        this.mode = commandLine.getOptionValue(CLIConfigurator.MODE_SYMBOL);
	        this.serviceId = commandLine.getOptionValue(CLIConfigurator.PROCESS_ID_SYMBOL);
	    }

	    public String getNetworkInterfaceName() {
	        return this.networkInterfaceName;
	    }

	    public String getMode() {
	        return this.mode;
	    }

	    public String getServiceId() {
	        return this.serviceId;
	    }

}
