package server;

public class ConfigUrl {

    public static String baseUrl = "http://172.32.1.173:5000";

    public static String getAllMhs = baseUrl + "/mahasiswa/getAllMhs";
    public static String inputDataMhs = baseUrl + "/mahasiswa/insert";
    public static String login = baseUrl + "/mahasiswa/login";
    public static String simpanMk = baseUrl + "/tokobaju/simpanmkandroid";
    public static String getMk = baseUrl + "/tokobaju/getmk";
    public static String ubahMk = baseUrl + "/tokobaju/updatemkandroid/";
    public static String deleteMk = baseUrl + "/tokobaju/deletemk/";
    public static String getMkDetail = baseUrl + "/tokobaju/getmk/";
    public static String simpanT = baseUrl + "/transaksi/simpanmkandroid";
    public static String getT = baseUrl + "/transaksi/getmk";
    public static String ubahT = baseUrl + "/transaksi/updatemkandroid/";
    public static String deleteT = baseUrl + "/transaksi/deletemk/";
    public static String getTDetail = baseUrl + "/transaksi/getmk/";

}