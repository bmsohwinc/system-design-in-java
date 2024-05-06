# Some Frequently used Design Principles

1. DRY - Don't repeat yourself

2. KISS - Keep it Simple

3. SOC - Separation of Concerns

4. Law of Demeter
- Object `a` shouldn't know about `2-nd level` information of an object (say `b`) that it has access to
- 1st level: b.m1(), b.m2(), b.prop, etc.
- 2nd level: b.m1().m3(), b.m2().k2().i2(), etc.
- E.g.: You command the car to turn right, but you don't command it to turn right **and** set its wheel speeds
- Nice read: https://en.wikipedia.org/wiki/Law_of_Demeter

5. 
