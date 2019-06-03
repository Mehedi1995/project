
package officeinvantoryapps;



public class product {

    String pname;
    String pcode;// data stored in the node
    String pprice;
    String pdescription;
    String pedate;
    String pquantity;

    product(String pname,String pcode, String pprice, String pdescription,  String pedate,String pquantity) {
        this.pname = pname;
        this.pcode = pcode;
        this.pprice = pprice;
        this.pdescription = pdescription;
        this.pedate = pedate;
        this.pquantity = pquantity;
    }

    public String getpname() {
        return pname;
    }

    public String getpcode() {
        return pcode;
    }

    public String getpprice() {
        return pprice;
    }

    public String getpdescription() {
        return pdescription;
    }

    public String getpedate() {
        return pedate;
    }

    public String getpquantity() {
        return pquantity;
    }

    public void setpname(String newpname) {
        pname = newpname;
    }

    public void setpcode(String newpcode) {
        pcode = newpcode;
    }

    public void setpprice(String newpprice) {
        pprice = newpprice;
    }

    public void setpdescription(String newpdescription) {
        pdescription = newpdescription;
    }

    public void setpedate(String newpedate) {
        pedate = newpedate;
    }

    public void setpquantity(String newpquantity) {
        pquantity = newpquantity;
    }

}
