package com.kevin.xml.jdbc_xml.entity;

import java.util.Date;

public class EfeeFlightPlan {

    private Integer flightplanid;

    private String callsign;

    private String aircrafttype;

    private String assrcode;

    private String adep;

    private String ades;

    private Integer ata;

    private Integer atd;

    private Integer cfl;

    private String controllingsector;

    private String fix;

    private Integer level;

    private Integer time;

    private Integer creationtimetimebaseid;

    private Integer creationtimeuniversalsec;

    private Integer lreationtimeuniversalusec;

    private String ctot;

    private String currentfix;

    private String dof;

    private Integer eobt;

    private Integer eta;

    private Integer etd;

    private Integer etdb;

    private String flightcategory;

    private String flighttypes;

    private String fplstatus;

    private String nextsector;

    private Integer holdingentrytime;

    private Integer holdingexittime;

    private String holdingpoint;

    private String holdingstatus;

    private Integer modificationtimetimebaseid;

    private Integer modificationtimeuniversalsec;

    private Integer modificationtimeuniversalusec;

    private String nbrofaircraft;

    private String opdata;

    private String previoussector;

    private Integer pssrcode;

    private String registrationnumber;

    private String routefield;

    private Integer uid;

    private String wtc;

    private String recid;

    private Date timestamp;

    @Override
    public String toString() {
        return "EfeeFlightPlan{" +
                "flightplanid=" + flightplanid +
                ", callsign='" + callsign + '\'' +
                ", aircrafttype='" + aircrafttype + '\'' +
                ", assrcode='" + assrcode + '\'' +
                ", adep='" + adep + '\'' +
                ", ades='" + ades + '\'' +
                ", ata=" + ata +
                ", atd=" + atd +
                ", cfl=" + cfl +
                ", controllingsector='" + controllingsector + '\'' +
                ", fix='" + fix + '\'' +
                ", level=" + level +
                ", time=" + time +
                ", creationtimetimebaseid=" + creationtimetimebaseid +
                ", creationtimeuniversalsec=" + creationtimeuniversalsec +
                ", lreationtimeuniversalusec=" + lreationtimeuniversalusec +
                ", ctot='" + ctot + '\'' +
                ", currentfix='" + currentfix + '\'' +
                ", dof='" + dof + '\'' +
                ", eobt=" + eobt +
                ", eta=" + eta +
                ", etd=" + etd +
                ", etdb=" + etdb +
                ", flightcategory='" + flightcategory + '\'' +
                ", flighttypes='" + flighttypes + '\'' +
                ", fplstatus='" + fplstatus + '\'' +
                ", nextsector='" + nextsector + '\'' +
                ", holdingentrytime=" + holdingentrytime +
                ", holdingexittime=" + holdingexittime +
                ", holdingpoint='" + holdingpoint + '\'' +
                ", holdingstatus='" + holdingstatus + '\'' +
                ", modificationtimetimebaseid=" + modificationtimetimebaseid +
                ", modificationtimeuniversalsec=" + modificationtimeuniversalsec +
                ", modificationtimeuniversalusec=" + modificationtimeuniversalusec +
                ", nbrofaircraft='" + nbrofaircraft + '\'' +
                ", opdata='" + opdata + '\'' +
                ", previoussector='" + previoussector + '\'' +
                ", pssrcode=" + pssrcode +
                ", registrationnumber='" + registrationnumber + '\'' +
                ", routefield='" + routefield + '\'' +
                ", uid=" + uid +
                ", wtc='" + wtc + '\'' +
                ", recid='" + recid + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public Integer getFlightplanid() {
        return flightplanid;
    }

    public void setFlightplanid(Integer flightplanid) {
        this.flightplanid = flightplanid;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign == null ? null : callsign.trim();
    }

    public String getAircrafttype() {
        return aircrafttype;
    }

    public void setAircrafttype(String aircrafttype) {
        this.aircrafttype = aircrafttype == null ? null : aircrafttype.trim();
    }

    public String getAssrcode() {
        return assrcode;
    }

    public void setAssrcode(String assrcode) {
        this.assrcode = assrcode == null ? null : assrcode.trim();
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep == null ? null : adep.trim();
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades == null ? null : ades.trim();
    }

    public Integer getAta() {
        return ata;
    }

    public void setAta(Integer ata) {
        this.ata = ata;
    }

    public Integer getAtd() {
        return atd;
    }

    public void setAtd(Integer atd) {
        this.atd = atd;
    }

    public Integer getCfl() {
        return cfl;
    }

    public void setCfl(Integer cfl) {
        this.cfl = cfl;
    }

    public String getControllingsector() {
        return controllingsector;
    }

    public void setControllingsector(String controllingsector) {
        this.controllingsector = controllingsector == null ? null : controllingsector.trim();
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix == null ? null : fix.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCreationtimetimebaseid() {
        return creationtimetimebaseid;
    }

    public void setCreationtimetimebaseid(Integer creationtimetimebaseid) {
        this.creationtimetimebaseid = creationtimetimebaseid;
    }

    public Integer getCreationtimeuniversalsec() {
        return creationtimeuniversalsec;
    }

    public void setCreationtimeuniversalsec(Integer creationtimeuniversalsec) {
        this.creationtimeuniversalsec = creationtimeuniversalsec;
    }

    public Integer getLreationtimeuniversalusec() {
        return lreationtimeuniversalusec;
    }

    public void setLreationtimeuniversalusec(Integer lreationtimeuniversalusec) {
        this.lreationtimeuniversalusec = lreationtimeuniversalusec;
    }

    public String getCtot() {
        return ctot;
    }

    public void setCtot(String ctot) {
        this.ctot = ctot == null ? null : ctot.trim();
    }

    public String getCurrentfix() {
        return currentfix;
    }

    public void setCurrentfix(String currentfix) {
        this.currentfix = currentfix == null ? null : currentfix.trim();
    }

    public String getDof() {
        return dof;
    }

    public void setDof(String dof) {
        this.dof = dof == null ? null : dof.trim();
    }

    public Integer getEobt() {
        return eobt;
    }

    public void setEobt(Integer eobt) {
        this.eobt = eobt;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Integer getEtd() {
        return etd;
    }

    public void setEtd(Integer etd) {
        this.etd = etd;
    }

    public Integer getEtdb() {
        return etdb;
    }

    public void setEtdb(Integer etdb) {
        this.etdb = etdb;
    }

    public String getFlightcategory() {
        return flightcategory;
    }

    public void setFlightcategory(String flightcategory) {
        this.flightcategory = flightcategory == null ? null : flightcategory.trim();
    }

    public String getFlighttypes() {
        return flighttypes;
    }

    public void setFlighttypes(String flighttypes) {
        this.flighttypes = flighttypes == null ? null : flighttypes.trim();
    }

    public String getFplstatus() {
        return fplstatus;
    }

    public void setFplstatus(String fplstatus) {
        this.fplstatus = fplstatus == null ? null : fplstatus.trim();
    }

    public String getNextsector() {
        return nextsector;
    }

    public void setNextsector(String nextsector) {
        this.nextsector = nextsector == null ? null : nextsector.trim();
    }

    public Integer getHoldingentrytime() {
        return holdingentrytime;
    }

    public void setHoldingentrytime(Integer holdingentrytime) {
        this.holdingentrytime = holdingentrytime;
    }

    public Integer getHoldingexittime() {
        return holdingexittime;
    }

    public void setHoldingexittime(Integer holdingexittime) {
        this.holdingexittime = holdingexittime;
    }

    public String getHoldingpoint() {
        return holdingpoint;
    }

    public void setHoldingpoint(String holdingpoint) {
        this.holdingpoint = holdingpoint == null ? null : holdingpoint.trim();
    }

    public String getHoldingstatus() {
        return holdingstatus;
    }

    public void setHoldingstatus(String holdingstatus) {
        this.holdingstatus = holdingstatus == null ? null : holdingstatus.trim();
    }

    public Integer getModificationtimetimebaseid() {
        return modificationtimetimebaseid;
    }

    public void setModificationtimetimebaseid(Integer modificationtimetimebaseid) {
        this.modificationtimetimebaseid = modificationtimetimebaseid;
    }

    public Integer getModificationtimeuniversalsec() {
        return modificationtimeuniversalsec;
    }

    public void setModificationtimeuniversalsec(Integer modificationtimeuniversalsec) {
        this.modificationtimeuniversalsec = modificationtimeuniversalsec;
    }

    public Integer getModificationtimeuniversalusec() {
        return modificationtimeuniversalusec;
    }

    public void setModificationtimeuniversalusec(Integer modificationtimeuniversalusec) {
        this.modificationtimeuniversalusec = modificationtimeuniversalusec;
    }

    public String getNbrofaircraft() {
        return nbrofaircraft;
    }

    public void setNbrofaircraft(String nbrofaircraft) {
        this.nbrofaircraft = nbrofaircraft == null ? null : nbrofaircraft.trim();
    }

    public String getOpdata() {
        return opdata;
    }

    public void setOpdata(String opdata) {
        this.opdata = opdata == null ? null : opdata.trim();
    }

    public String getPrevioussector() {
        return previoussector;
    }

    public void setPrevioussector(String previoussector) {
        this.previoussector = previoussector == null ? null : previoussector.trim();
    }

    public Integer getPssrcode() {
        return pssrcode;
    }

    public void setPssrcode(Integer pssrcode) {
        this.pssrcode = pssrcode;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber == null ? null : registrationnumber.trim();
    }

    public String getRoutefield() {
        return routefield;
    }

    public void setRoutefield(String routefield) {
        this.routefield = routefield == null ? null : routefield.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWtc() {
        return wtc;
    }

    public void setWtc(String wtc) {
        this.wtc = wtc == null ? null : wtc.trim();
    }

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid == null ? null : recid.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}