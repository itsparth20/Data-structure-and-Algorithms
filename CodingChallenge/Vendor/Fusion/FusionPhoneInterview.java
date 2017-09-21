/*
For this exercise, you can use pseudocode or a specific language of your choice. 
Given a array of 'patients' implement a method that returns true if all of the following are true; false otherwise.
- The number of male patients is smaller than number of female patients.
- The average age of female patients is greater than the average age of male patients.
- No patient is older than 122 years.
You can assume that the 'Patient' object has two properties: age (int) and gender (char).
You don't need to set up an infrastructure (Main method, etc.),  just provide the method logic. 
*/
//Sample method signature
public bool CheckPatientAgeCriteria(Patient[] patients)
{
  int maleCount = 0, femaleCount = 0, maleAgeSum = 0, femaleAgeSum = 0;
  
  for(Patient obj : patients){
      if(obj.age > 122) return false;
      else if(obj.gender == 'm'){ 
        maleCount++;
        maleAgeSum += obj.age;
      }
      else if(obj.gender == 'f'){ 
        femaleCount++;
        femaleAgeSum += obj.age;
      }
  }  
  
  if(maleCount >= femaleCount) return false;
  
  if( (maleAgeSum/maleCount) >= (femaleAgeSum/femaleCount) ) return false;
  
  return true;
}