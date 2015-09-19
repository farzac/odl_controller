package org.farzac.opendaylight.mediator;

import org.opendaylight.controller.sal.core.Node;
import org.opendaylight.controller.sal.core.NodeConnector;
import org.opendaylight.controller.sal.packet.BitBufferHelper;
import org.opendaylight.controller.sal.packet.Ethernet;
import org.opendaylight.controller.sal.packet.IDataPacketService;
import org.opendaylight.controller.sal.packet.IListenDataPacket;
import org.opendaylight.controller.sal.packet.Packet;
import org.opendaylight.controller.sal.packet.PacketResult;
import org.opendaylight.controller.sal.packet.RawPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardingReceivingDataPackets implements IListenDataPacket {
	private static final Logger logger = LoggerFactory.getLogger(ForwardingReceivingDataPackets.class);
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
	 * Function called by the dependency manager when at least one dependency
	 * become unsatisfied or when the component is shutting down because for
	 * example bundle is being stopped.
	 *
	 */
	void destroy() {
	}

	/**
	 * Function called by dependency manager after "init ()" is called and after
	 * the services provided by the class are registered in the service registry
	 *
	 */
	void start() {
		logger.info("Started");
	}

	/**
	 * Function called by the dependency manager before the services exported by
	 * the component are unregistered, this will be followed by a "destroy ()"
	 * calls
	 *
	 */
	void stop() {
		logger.info("Stopped");
	}

	@Override
	public PacketResult receiveDataPacket(RawPacket inPkt) {
		Packet formattedPak = this.dataPacketService.decodeDataPacket(inPkt);
		NodeConnector incoming_connector = inPkt.getIncomingNodeConnector();
		Node incomingNode = incoming_connector.getNode();
		if (formattedPak instanceof Ethernet) {
			byte[] srcMAC = ((Ethernet) formattedPak).getSourceMACAddress();
			byte[] dstMAC = ((Ethernet) formattedPak).getDestinationMACAddress();
			long srcMAC_val = BitBufferHelper.toNumber(srcMAC);
			long dstMAC_val = BitBufferHelper.toNumber(dstMAC);
			byte[] payload = inPkt.getPacketData();
			Object nextPak = formattedPak.getPayload();
			String s[] = nextPak.toString().split(",");
			for (int i = 0; i < s.length; i++) {
				s[i] = s[i].trim();
			}
			System.out.println("--Segue abaixo os dados do pacote referente a interface IListenDataPacket -- ");
			System.out.println("O tamanho do pacote:" + inPkt.getPacketData().length + " - MAC da maquina origem:"
					+ srcMAC_val + " - MAC da maquina destino:" + dstMAC_val + " - Tipo encapsulamento:"
					+ inPkt.getEncap() + " - Payload : " + payload + " - Nó: " + incoming_connector + " - Nó Node: "
					+ incomingNode + " - PacketData :" + inPkt.getPacketData() + " - " + s[1] + " - " + s[2] + " - "
					+ s[3] + " - " + s[5] + " - " + s[6] + " - " + s[7] + " - " + s[8]);
			if (inPkt.toString().contains("IPv4")) {
				System.out.println("Handle IP packet: {}" + formattedPak);
			} else if (inPkt.toString().contains("ARP")) {
				System.out.println("Handle ARP packet: {}" + formattedPak);
			}
		}

		if (inPkt != null) {
			logger.info("Received packet " + inPkt);
		}
		return PacketResult.IGNORED;
	}
}