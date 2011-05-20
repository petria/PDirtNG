EXITS
List all obvious exits.

[PGoto]EXITS <location>               Lists the exits from <location>.
[PRoomEdit]EXITS <location> <direction> <new location>
[PRoomEdit]                               will change the exit in the given
[PRoomEdit]            direction in the given room to the <new location>.
[PRoomEdit]            Directions are North, South etc. and may be abbreviated.

[PRoomEdit]If no <location> is given, your current location is assumed.
[PRoomEdit]If no <new location> is given, the <direction> exit will be cleared.

[PRoomEdit]Examples: EXITS s start1       will change the southern exit in your
[PRoomEdit]                               current location to start1.
[PRoomEdit]          EXITS home1 west home2
[PRoomEdit]                     will change the western exit in home1 to home2.
[PRoomEdit]          EXITS home1 up       will remove the 'up' exit from home1.
[PRoomEdit]          EXITS u              ditto, for your current location.
[PGoto|PRoomEdit]See also ROOM
^
