package psic;

//Member details like ID, Name, Address and Telphone
public class Member {
    private  String id[] = {"1","2","3","4","5"};
    private  String name[] = {"MR.David","MR.Ron","MR.Eric","Mr.Ali","Mr.Shoun"};
    private  String address[] = {"St# 5, NY212","St# 8,Chicago","St# 1, Grandorchard","St# 6, LA"};
    private  String telp [] = {"123456","456231","789456","987654"};

    public String[] getId(){
        return this.id;
    }
    public String[] getName(){
        return this.name;
    }
    public String[] getAddress(){
        return this.address;
    }
    public String[] getTelp(){
        return this.telp;
    }
    
    
}
