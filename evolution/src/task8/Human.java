package task8;

class Human {
	   protected String Name;
	   protected String Surname;
	   
	   public Human(String Name, String Surname) {
	      this.Name=Name;
	      this.Surname=Surname;
	   }
	   
	   public Human(Human H) {
	      this(H.Name, H.Surname);
	   }
	   
	   final public String getName() {
	      return Name;
	   }
	   final public String getSurname() {
	      return Surname;
	   }
	   final public void setName(String Name) {
	      this.Name=Name;
	   }
	   final public void setSurname(String Surname) {
	      this.Surname=Surname;
	   }
	   
	   @Override   
	   public String toString() {
	      return "Name: " + Name + ".   Surname: " + Surname;
	   }
	}

