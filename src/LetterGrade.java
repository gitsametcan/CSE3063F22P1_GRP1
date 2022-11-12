//Samet CAN 150120528
public enum LetterGrade {
	AA(4.00),
	BA(3.50),
	BB(3.00),
	CB(2.50),
	CC(2.00),
	DC(1.50),
	DD(1.00),
	FD(0.50),
	FF(0.00);
	
	private final double grade;

    private LetterGrade(double Grade) {
        this.grade = Grade;
    }
    
    public double getLetterGradeValue() {
    	return this.grade;
    }
}
