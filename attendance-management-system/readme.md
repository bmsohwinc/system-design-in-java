# Attendance management system for Schools

## Requirements
1. Class teachers mark whether a Student is present or absent for the day in the class
2. Teachers and Staff members mark their attendance for the day in school registry
3. Teachers can view attendance of students for any given day
4. Principal can view attendance of Teachers and Staff for any given day

## Nouns
1. Student
2. Teacher
3. Staff
4. Principal
5. School
6. Class
7. Attendance Registry

## Nouns
1. Mark attendance
2. View attendance

## Class diagrams/UML model
```
"->" means extended by - Inheritance
"-" means just a member field

1. Abstract Person
    -> Student
    -> Teacher
    -> Staff
    -> Principal
2. School
    - SchoolId
    - Principal
    - List<Class>
    - List<Teacher>
    - List<Staff>
    - TeacherAttendanceRegistry
    - StaffAttendanceRegistry
3. Class
    - ClassId
    - List<Student>
    - Teacher
    - StudentAttendanceRegistry
3. Student
    - 
```