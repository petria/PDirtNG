PROMPT <new-prompt>
Eradicated Worlds has a very flexible prompt system. It allows you to put
vital information such as score, strength etc. in the prompt so it is always
visible to you. Here are some options you can use to build your prompt:

    %s : prints the score in your prompt
    %H : prints the maximum strength for your level.
    %h : prints the current strength. The strength is colored green/yellow/red
         depending on the remaining strength you have.
    %q : prints the current amount of acquired questpoints.
    %Q : prints the amount of questpoints required to reach the next level.
    %a : prints an armor status.
    %d : prints an damage status.
         
         The armor and damage status can take the following forms:
         A:&+R.&* = poorly armoured       D:&+R.&* = poor damage
         A:&+Y+&* = fairly armoured       D:&+Y+&* = fair damage
         A:&+G*&* = good armour           D:&+G*&* = good damage
         A:&+Co&* = excellent armour!     D:&+Co&* = excellent damage!
      
Besides these codes, you can also use the normal colorcodes to colorize the 
stats and prompt. The code &&N allows you to make multilined prompts if you
should desire to do so, it is not advised however.

It isn't needed to have the strength in your prompt. When you don't have it,
and you start a fight, it will automatically appear in front of your prompt
like it does on most other abers.
[X]
[X]When an immortal player goes invisible, it will automatically show your 
[X]visibility in front of your prompt.

NOTE: Using long prompts with compact mode can get pretty ugly!

&+WSee Also: &+CSCOREPROMPT
^
