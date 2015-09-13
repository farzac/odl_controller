package br.com.farzac.opendaylight.mediador;

import org.opendaylight.controller.sal.packet.IDataPacketService;
import org.opendaylight.controller.sal.packet.IListenDataPacket;
import org.opendaylight.controller.sal.packet.PacketResult;
import org.opendaylight.controller.sal.packet.RawPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardingReceivingDataPackets implements IListenDataPacket {
    private static final Logger logger = LoggerFactory
            .getLogger(ForwardingReceivingDataPackets.class);
    private IDataPacketService dataPacketService = null;

    void setDataPacketService(IDataPacketService s) {
        this.dataPacketService = s;
    }

    void unsetDataPacketService(IDataPacketService s) {
        if (this.dataPacketService == s) {
            this.dataPacketService = null;
        }
    }

    /**
     * Function called by the dependency manager when all the required
     * dependencies are satisfied
     *
     */
    void init() {
        logger.info("Initialized");
    }

    /**
     * Function called by the dependency manager when at least one
     * dependency become unsatisfied or when the component is shutting
     * down because for example bundle is being stopped.
     *
     */
    void destroy() {
    }

    /**
     * Function called by dependency manager after "init ()" is called
     * and after the services provided by the class are registered in
     * the service registry
     *
     */
    void start() {
        logger.info("Started");
    }

    /**
     * Function called by the dependency manager before the services
     * exported by the component are unregistered, this will be
     * followed by a "destroy ()" calls
     *
     */
    void stop() {
        logger.info("Stopped");
    }

    public PacketResult receiveDataPacket(RawPacket inPkt) {
        if (inPkt != null) {
	    logger.info("Received packet " + inPkt);
	}
	return PacketResult.IGNORED;
    }
}
