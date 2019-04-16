package com.tan.nioexample.application.heartbeat;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CLIConfigurator {
	  static final char NETWORK_INTERFACE_NAME_SYMBOL = 'n';
	    static final char MODE_SYMBOL = 'm';
	    static final char PROCESS_ID_SYMBOL = 'i';

	    private static final Options CLI_OPTIONS = new Options();
	    static {
	        CLI_OPTIONS.addOption(String.valueOf(MODE_SYMBOL), true, "The mode of the process: eg: MULTICAST or SUBSCRIBE");
	        CLI_OPTIONS.addOption(String.valueOf(NETWORK_INTERFACE_NAME_SYMBOL), true, "The network interface name: eg eth0");
	        CLI_OPTIONS.addOption(String.valueOf(PROCESS_ID_SYMBOL), true, "The id of the process");
	    }

	    private CLIConfigurator() {
	        throw new IllegalStateException(Constants.INSTANTIATION_NOT_ALLOWED);
	    }

	    static Optional<CLIConfig> configure(final String... args) {
	        assert !Objects.isNull(args);

	        Optional<CLIConfig> result = Optional.empty();

	        try {
	            final CommandLineParser parser = new DefaultParser();
	            final CommandLine cmd = parser.parse(CLI_OPTIONS, args);

	            if (cmd.hasOption(MODE_SYMBOL) && cmd.hasOption(NETWORK_INTERFACE_NAME_SYMBOL) && cmd.hasOption(PROCESS_ID_SYMBOL)) {
	                result = Optional.of(new CLIConfig(cmd));
	            } else {
	                printUsage();
	            }
	        } catch (ParseException e) {
	            printUsage();
	        }

	        return result;
	    }

	    private static void printUsage() {
	        final HelpFormatter help = new HelpFormatter();
	        help.printHelp("Running heartbeat", CLI_OPTIONS);
	    }

}
