[PSyslog]SYSLOG
[PSyslog]
[PSyslog]Displays selected portions of the syslog. Without argument, it prints
[PSyslog]the log for the current day. An argument may be one of the following:
[PSyslog]
[PSyslog] a number n - display the last n lines of the syslog
[PSyslog] a string   - display all the lines containing that string
[PSyslog] a pattern  - display all lines matching that pattern
[PSyslog]
[PSyslog] Some examples:
[PSyslog]
[PSyslog]   syslog 10                   display last ten lines of the log
[PSyslog]   syslog snoop                check see who snooped who
[PSyslog]   syslog ENTRY*mit.edu        show logins from any mit.edu machine
[PSyslog]
[PSyslog] Type HELP PATTERN for more information on patterns.
[PSyslog]
[PSyslog]&+GSee also:&+W buglog, suggestlog
[PSyslog]^
