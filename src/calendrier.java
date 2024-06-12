public class calendrier {
    private String heureDebut;
    private String heureFin;
    public calendrier( String HD, String HF){
        this.heureDebut=HD;
        this.heureFin=HF;
    }

    public String getHeureFin() {
        return heureFin;
    }
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    public String getHeureDebut() {
        return heureDebut;
    }
    public String getCalendrier(){
        return"Calendrier{de "+getHeureDebut()+"à"+getHeureFin()+"}";
    }
}
