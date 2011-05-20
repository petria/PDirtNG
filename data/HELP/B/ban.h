[PBanPlayer & !PbanHost]BAN <player|report>
[PBanPlayer & PBanHost]BAN <player|host [host]|lock [host]|report>
[!PBanPlayer & PBanHost]BAN <host [host]|lock [host]|report>
[PBanPlayer]Bans a player by putting the name in the banned_chars file. Once it is in
[PBanPlayer]the file it can only be removed by someone who has access to the files.
[PBanHost]
[PBanHost]the host ban allows you to ban every login from one site. The lock feature
[PBanHost]allows you to ban all new players from a site, but not old players.
[PBanHost]The '*' wildcard is allowed. So a ban sites using the '*' wildcard.
[PBanPlayer | PBanHost]
[PBanPlayer]Example of how to ban a player:
[PBanPlayer]fban foo
[PBanHost]Example on how to ban a host:
[PBanHost]fban host ctr4.nowhere.xx
[PBanHost | PBanPlayer]
[PBanHost | PBanPlayer]After banning someone, use report to explain why.
[PBanHost | PBanPlayer]^
