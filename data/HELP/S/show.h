[PStats]SHOW [item]
[PStats]Gives detailed information about an item.  Meanings of information
[PStats]shown are as follows:
[PStats]
[PStats]State:          Current state of object (open, closed, full, charged..)
[PStats]Max State:      The maximum state number.
[PStats]Base Value:     The maximum value this object can have.
[PStats]                Actual value is: MIN(#players, 9) / 9 * Base Value
[PStats]Damage:         If this is a weapon, how much damage does it do.
[PStats]                Total damage = random(0, 8 + weapon-damage) if player,
[PStats]                If a mobile has it: random(0, mob-dam + 1/2 * weap-dam)
[PStats]Armor Class:    If this is armor, with what percentage does it reduce
[PStats]                your opponents chance to hit you ? (starting at 57%)
[PStats]Size:           How much space does item take up in pack.
[PStats]                If it's a container, how much it can contain.
[PStats]Properties:     Wearable, weapon, edible, NoGet, etc. (See help OFLAGS)
[PStats]Descriptions:   One-line descriptions for each state.
[PStats]^
