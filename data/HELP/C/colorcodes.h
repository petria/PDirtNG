COLORCODES

&+RCO&+GLO&+YRC&+BOD&+MES&+C!

For all of you with ansi color screens.  These codes allows you to set the
colors of your says, tells, title...

 & + <color>               for foreground
 & - <color>               for background
 & = <fg color><bg color>  to set both foreground and background
 & *                       resets the colors to standard settings

(Note that you have to concatenate the code string, that is, no space
 between & and + and <color> for instance.)

code   represents      code   represents
---------------------------------------------------
 &+ll      black           &+LL      black,   highlighted
 &+bb      blue            &+BB      blue,    highlighted
 &+cc      cyan            &+CC      cyan,    highlighted
 &+gg      green           &+GG      green,   highlighted
 &+mm      magenta         &+MM      magenta, highlighted
 &+rr      red             &+RR      red,     highlighted
 &+ww      white           &+WW      white,   highlighted
 &+yy      yellow          &+YY      yellow,  highlighted

Example: &#mWHello where # is a '=' will result in the text '&=mWHello&*'.
         &#GHiya   where # is a '+' will result in the text '&+GHiya&*'.
         &#CHi     where # is a '-' will result in the text '&-CHi&*'.
^
