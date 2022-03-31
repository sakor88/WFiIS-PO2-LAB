public enum Option{
    RESET('r', "resetowanie gry", null),
    LEFT('a', "ruch w lewo", Direction.LEFT),
    RIGHT('d', "ruch w prawo", Direction.RIGHT),
    UP('w', "ruch w gore", Direction.UP),
    DOWN('s', "ruch w dol", Direction.DOWN),
    EXIT('q', "wyjscie z gry", null);


    private final char znak;
    private final String opis;
    private final Direction kierunek;

    Option(char znak, String opis, Direction kierunek){
        this.znak = znak;
        this.opis = opis;
        this.kierunek = kierunek;
    }

    public void printOpcje(){
        System.out.print(this);
    }

    public String getOpis(){
        return this.opis;
    }
    public char getZnak(){
        return this.znak;
    }
    public Direction getKierunek(){
        return this.kierunek;
    }

    public String toString() {
		return "\'" + this.znak + "\'" + "==>" +  " opcja " + this.name() + ", opis: " + this.getOpis() + ",\n wektor przesuniecia: "+ this.getKierunek();
	}
}