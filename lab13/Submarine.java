public class Submarine{

    int horizontalPosition;
    int depth;
    int aim;


    Submarine(){
        this.horizontalPosition = 0;
        this.depth = 0;
        this.aim = 0;
    }

    void forward(int x){
        this.horizontalPosition = this.horizontalPosition + x;
        this.depth = this.depth + this.aim * x;
    }

    void down(int x){
        this.aim = this.aim + x;
    }

    void up(int x){
        this.aim = this.aim - x; 
    }

    void printPos(){
        System.out.println("Pozycja: " + this.horizontalPosition);
        System.out.println("Glebokosc: " + this.depth );
        System.out.println("Cel: " + this.aim );
    }

    int getPos(){
        return this.horizontalPosition;
    }

    int getDepth(){
        return this.depth;
    }

}