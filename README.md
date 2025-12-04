# Simple_Resume
# Simple Resume Generator (Java CLI)

What it does:
- Ask for your name, contact, short summary
- Ask for one or more experiences (company, role, dates, responsibilities)
- Generate `output/resume.txt` — plain, ATS-friendly

Requirements:
- Java 11+ (works on Java 8 too)
- (Optional) Maven

Run without Maven:
1. Save files under `src/main/java/com/simpleapp/resume/` and template under `templates/`
2. Compile:
   javac -d out $(find src -name "*.java")
3. Run:
   java -cp out com.simpleapp.resume.Main

Run with Maven:
1. `mvn clean package`
2. `java -jar target/simple-resume-1.0.jar`

