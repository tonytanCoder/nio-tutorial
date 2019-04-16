package com.tan.nioexample.application.heartbeat;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public enum Mode {
	  MULTICAST() {
	        public void execute(final CLIConfig config) {
	            if (Objects.isNull(config)) {
	                throw new IllegalArgumentException("required config");
	            }

	            final CountDownLatch endLatch = new CountDownLatch(1);
	            Runtime.getRuntime().addShutdownHook(new Thread() {
	                public void run() {
	                    endLatch.countDown();
	                }
	            });

	            new Multicaster(config.getServiceId(), Constants.Broadcast.MULTICAST_IP, config.getNetworkInterfaceName(), Constants.Broadcast.MULTICAST_PORT,
	                    Constants.Schedule.POOL_SIZE).run(endLatch);
	        }
	    },
	    SUBSCRIBE() {
	        public void execute(final CLIConfig config) {
	            if (Objects.isNull(config)) {
	                throw new IllegalArgumentException("required config");
	            }

	            new Subscriber(config.getServiceId(), Constants.Broadcast.MULTICAST_IP, config.getNetworkInterfaceName(), Constants.Broadcast.MULTICAST_PORT, Constants.Schedule.POOL_SIZE).run();
	        }
	    };

	    public abstract void execute(CLIConfig config);

}
