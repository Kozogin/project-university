Project university

User
for logging in the entrant and the commission member.
for the entrant the id and the password is assigned automatically

Applicant
contains the given forms of the entrant
[one to one] (User and Applicant)
[one to many] (Faculty and Applicant)

Faculty

NameOfLesson
lessons that are needed for this faculty [one to many] (Faculty and NameOfLesson)

FacultyLesson
object for implementation  [many to many] (Faculty and NameOfLesson)

Point
object for implementation  [many to many] (Applicant and NameOfLesson)




Repository


