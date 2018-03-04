# AcornAPI

## [JS Version(Thanks to huchenlei)](https://github.com/huchenlei/acorn-api-js)
## [Install via NPM](https://www.npmjs.com/package/acorn-api) 


## Example

### Login
```java
Acorn example = new Acorn("UTORid", "Password");
try {
	example.doLogin();
} catch (LoginFailedException e) {
	e.printStackTrace();
	// do something...
}
```

### Get Registrations
```java
// you need to provide registration index(the index of the returned array ) to do further action. ie. Get Course Info
List<String> eligibleRegistrations = example.getEligibleRegistrations();
```

### Get Student Courses
```java
List<EnrolledCourse> appliedCourse = example.getCourseManager().getAppliedCourses();
List<PlannedCourse> plannedCourse = example.getCourseManager().getPlannedCourses();
```

### Get Course Info (can also use it to get waiting list rank for a waitlisted course)
```java
int registrationIndex = 0;
String courseCode = "CSC373H1", sectionCode = "Y", courseSessionCode = "20175";
EnrolledCourse course = example.getCourseManager().loadExtraInfo(courseCode, courseSessionCode, sectionCode, registrationIndex);
```

### Get Course current space
```java
String spaceInfo = example.getCourseManager().getCourseSpace();
```

### Enroll a Course
```java
int registrationIndex = 0;
String courseCode = "CSC373H1", sectionCode = "Y", lecSection = "LEC,5101";
boolean result = example.getCourseManager().enroll(registrationIndex, courseCode, sectionCode, lecSection);
```

### Get Current Transcript
```java
String transcriptHtml = example.getGradeManager().getGradeHtml();
```

### Get Invoice (not yet implemented)
```java
String session = "?";
String invoiceHtml = example.getAccountManager().getInvoice(session);
```
