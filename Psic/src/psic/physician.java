package psic;


public class physician {
    private String experties[] = {"Physiotherapy", "Osteopathy", "Rehabilitation","Osteopathy","Physiotherapy"};//Details of All expertise
    private String Treatment[] = {"Neural mobilisation", "Acupuncture", "Massage","Mobilisation of the spine and joints","Pool rehabilitation"};//Details of treatments

    
    public String[] getExperties(){
        return this.experties;
    }
    public String[] getTreatment(){
        return this.Treatment;
    }
}
