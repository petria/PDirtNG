PATTERN

&+WThis code is obsolete because of the use of a new parser.&*

Some commands support the *, ? and \ wildcards.

        * = match 0 or more characters
        ? = match exactly one character
        \ = match the next character literally.

examples:

        *               = match anything, this never fails.
        d*k             = match anything beginning with d and ending in k
                                (could be "datebook", "dork", etc..)
        si??            = match any 4-letter word starting with "si".
                                (could be "sigh", "sign", but not "sip".
        Where\?         = matches to the string "Where?"
^
