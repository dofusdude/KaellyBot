package com.github.kaysoro.kaellybot.portal.model.dto;

import com.github.kaysoro.kaellybot.portal.model.entity.Transport;

public class PortalDto {

    private String server;
    private String dimension;
    private PositionDto position;
    private Transport nearestZaap;
    private Transport nearestTransportLimited;
    private boolean transportLimitedNearest;

    public PortalDto withServer(String server) {
        this.server = server;
        return this;
    }

    public PortalDto withDimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public PortalDto withNearestZaap(Transport nearestZaap) {
        this.nearestZaap = nearestZaap;
        return this;
    }

    public PortalDto withNearestTransportLimited(Transport nearestTransportLimited) {
        this.nearestTransportLimited = nearestTransportLimited;
        return this;
    }

    public PortalDto withTransportLimitedNearest(boolean transportLimitedNearest) {
        this.transportLimitedNearest = transportLimitedNearest;
        return this;
    }

    public PortalDto withPosition(PositionDto position) {
        this.position = position;
        return this;
    }

    public String getServer() {
        return server;
    }

    public String getDimension() {
        return dimension;
    }

    public PositionDto getPosition() {
        return position;
    }

    public Transport getNearestZaap() {
        return nearestZaap;
    }

    public Transport getNearestTransportLimited() {
        return nearestTransportLimited;
    }

    public boolean isTransportLimitedNearest() {
        return transportLimitedNearest;
    }
}