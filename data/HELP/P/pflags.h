[!PPflagEdit]PFLAGS <ME> <privilege> <true/false>.
[!PPflagEdit]or CHANGE PFLAGS <ME> <privilege> <true/false>.
[PPflagEdit]PFLAGS <player> <privilege> <True/False>
[PPflagEdit]or CHANGE PFLAGS [player] [privilege] <True/False>
Set/check player's privileges.  If the third argument is missing (True/False)
the current status of that privilege will be shown.  A TRUE in the third
argument means "turn pflag on", FALSE means  "turn pflag off".  Privilege
is one of those names that shows up when you do:
>MASK ME (see the help on that command).

Example:

PFLAGS kantele nozap false
PFLAGS me zap true
zap kantele
[!Y]
[!Y]  Available pflags:
[MNoExorcise]NoExorcise:        Protects you from being exorcised.
[MNoSnoop]NoSnoop:              Protects you from being snooped on.
[MNoHassle]NoHassle:            Protects you from being attacked.
[MNoAlias]NoAlias:              Protects you from being aliased into.
[MNoZap]NoZap:                  Protects you from being zapped.
[MNoSummon]NoSummon:            Protects you from being summoned.
[MNoTrace]NoTrace:              Protects you from being traced.
[MNoSteal]NoSteal:              Protects you from being robbed.
[MNoMagic]NoMagic:              Protects you from being blinded et.c.
[MNoForce]NoForce:              Protects you from being forced.
[MFrob & MChScore & MChLevel]\
Frob and ChScore and ChLevel:           You may use the frob command.
[MChScore & MFrob]ChScore and Frob:             You may change score.
[MChScore & !MFrob]ChScore:             You may change your own score.
[MChLevel & MFrob]\
ChLevel and Frob:               You may change other people's level.
[MChMobData]\
ChMobData:              You may change strength, damage and aggression
[MChMobData]                    of mobiles.
[MPflagEdit]PflagEdit:          You may change other people's pflags.
[MMaskEdit]MaskEdit:            You may do anything you want oh mighty god.
[MRoomEdit]RoomEdit:            You may change lflags and exits on locations.
[MMflagEdit]MflagEdit:          You may change mflags of mobiles.
[MObjectEdit]ObjectEdit:        You may change oflags of objects.
[MTitleEdit]TitleEdit:          You may change title and setins permanently.
[MUAFInfo]UAFInfo:              Stats, frob, pflags, et.c work on people who
[MUAFINfo]                      are not in the game at the moment.
[MExorcise]Exorcise:            You may exorcise players from the game.
[MReset]Reset:                  You may reset the game at will.
[MSnoop]Snoop:                  You may snoop on players.
[MHeal]Heal:                    You may heal players.
[MAliasMob]AliasMob:            You may alias mobiles.
[MAliasPlayer]AliasPlayer:     You may alias other players.
[MRaw]Raw:                      You may use RAW and ECHOALL commands.
[MEmote]Emote:                  You may use EMOTE and EMOTETO commands.
[MEcho]Echo:                    You may use ECHO and ECHOTO commands.
[MObjectEdit]ObjectEdit:        You may set an object's state.
[MZap]Zap:                      You may zap other players....
[MResurrect]Resurrect:          You may RESSURECT things...
[MShowUsers]ShowUsers:          Account name or host name shows up...
[MStats]Stats:                  You may use STATS and SHOW commands.
[MGoto]Goto:                    You may use GOTO and IN/AT...
[MSummonObj]SummonObj:          You may summon objects...
[MWeather]Weather:              You may change the weather at will...
[MLock]Lock:                    You may WIZLOCK the game.
[MWreckDoors]WreckDoors:        You may wreck the doors.
[MPeace]Peace:                  You may use PEACE and WAR commands.
[MSyslog]MSyslog:               You may use the SYSLOG command.
[MStartInvis]\
StartInvis:     You will enter the game with your saved visibility level.
[MTrace]Trace:                  You may trace players and items.

Important: You can only use names that shows up on MASK ME command.
[!PPflagEdit]You may only do MASK ME.
^
