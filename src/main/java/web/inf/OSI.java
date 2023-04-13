package web.inf;

public class OSI {
    private String osi = "The Open Systems Interconnection model";
    private String osiTranslation = "Модель взаимодействия открытых систем";

    public void abbreviation() {
        System.out.println(osi);
        System.out.println(osiTranslation);
    }

    void networkLayer() {
        /*
        switch/commutator --------> it have memory to save MAC&IMEI and ports to use it separately
        в дополнение появляется IP address
        ROUTER -> NEW LEVEL DEVICE
        ROUTER WORK WITH IP AND IMEI/MAC ADDRESSES
        It has two interfaces inner and outer and it make name addresses to another devises
         */
    }

    void dataLink() {
/*
СВИЧ это КАНАЛЬНЫЙ УРОВЕНЬ СВИЧ / коммутатор на канальном уровне
at the line we receive data pocket  with control sum.
frame data:        frame start point    ->    data   ->    control sum    ->   frame end point
issue: data transfer queue
MAC on smartphone        &           IMEI Routers
 */
    }


    void physical() {
/*
REPEATER
HUB      -> соединяет по проводам много устройств  в одно, сегодня редко
MODEM
 */
    }

    void model() {
        /*
        HOST -> OSI MODEL ----------> TCP/IP ------------------------------> Protocols

                                        Application                        HTTP...
                                        Transport                          TCP, UDP
                                        Network                            IPv4...
                                        Network Interface                  MAC, LLC
                                        Network Interface                  WiFi, DSL

                      Application
                      Presentation
                      Session
                      Transport
                      Network
                      Data lInk
                      Physical
         */
        physical();
        dataLink();
    }
}
