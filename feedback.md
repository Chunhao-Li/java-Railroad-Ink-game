# Assignment Two Feedback

## Group  tue09a
## Group members: "u6527752","Li","Chunhao","","u6720989","Liu","Haoyan","","u6502811","Sima","Mingchao"

## Tutor Comment

Fantastic job for completing all the tasks
I really like your gui design, simple, elegant with nice music in the background.
I really like your AI to AI mode, which is a good demonstration/comparasion between AI players
Would be great if you could allow user to replace a tile in the case of an accidental misplacement
Some tiles are really hard to grab given it's shape, it would allow a more smooth user experience if you could group a transparent
rectangle with the tile and allow a larger area for actuating dragging/rotating/flipping
would be nice if you have set up a return button for users to go back to the initial starting page and re-select play mode
would be nice if you could allow for user to keep playing without switching to AI component, and score could be updated as the 
game progresses instead of showing the score at the end of the game

In terms of code, really good job finishing all the tasks. But you have chosen to implement everything in the Railroadlink
class and use the string data structure we have provided. While I am sure you have mastered various string manipulation 
techniques throughout the process, String is not the most efficient way to represent information in some scenarios. I 
would love to see some design on the data structure. It also defeat the purpose of Object orient programming if you choose
to let the logic flow in one single class

Overall, you guys have done a fantastic job finishing all the tasks! Best of luck with your final exams!


## Mark

**  9.5/11.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
||All files correct                     | /.25 |
||Authorship clear for all classes      | /.25 |
||Appropriate use of Git                | /.5  |
||Program runs from JAR                 | /.25 |
|P|Appropriate use of OO features       | -.5/.5  |
|P|Presentation PDF complete            | /.5  |
|CR|Program well designed               | /.5  |
|CR|Comments clear and sufficient       | /.5  |
|CR|Coding style good                   | /.25 |
|CR|Appropriate use of JUnit tests      | /.5  |
|D|Design and code of very high quality | /.25 |
|D|Demonstrates interesting extensions  | -.25/.25 |
|D|Works well and easy to run           | /.25 |
|HD|Game is exceptional                 | -.5/.5  |

**Total for miscellaneous marks:**  4/5.25

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Tiles snap into place            | /.25 |
|CR|Tiles can be rotated and flipped | /.25 |
|CR|Only valid placements allowed    | /.25 |
|CR|Basic score at game end          | /.25 |
|D |Basic computer opponent          | /.25 |
|HD|Advanced computer opponent       | -.25/.5  |

**Total for manual marks:** 1.5/1.75

## Test results

| Task | Test | Result | Marks |
|:-:|---|:-:|:-:|
| |Compiled|.25/.25|.25|
|2|IsTilePlacementWellFormed|3/3|.5|
|3|IsBoardStringWellFormed|6/6|.5|
|5|AreConnectedNeighbours|5/5|.5|
|6|IsValidPlacementSequence|5/5|.5|
|7|GenerateDiceRoll|4/4|.25|
|8|GetBasicScore|4/4|.5|
|10|GenerateMove|5/5|.5|
|12|GetAdvancedScore|2/2|.5|

**Total for tests:** 4.00/4.0

## Originality statements

#### Originality statement G
We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work.


Signed: Chunhao Li (u6527752), Haoyan Liu (u6720989), and Mingchao Sima (u6502811)

#### Originality statement F
We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work.


Signed: Chunhao Li (u6527752), Haoyan Liu (u6720989), and Mingchao Sima (u6502811)

#### Originality statements E
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work

Signed: Mingchao Sima (u6502811)
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work.

Signed: Chunhao Li (u6527752)
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work, with the
following documented exceptions:

* No exception. All the test code and exit code are finished on my own.

Signed: Haoyan Liu (u6720989)

#### Originality statements D
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The code in class <Viewer> uses an idea suggested by <Assignment 1>

Signed: Mingchao Sima (u6502811)
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The code in class <Viewer> uses an idea suggested by <Assignment 1>

Signed: Chunhao Li (u6527752)
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The idea of <Viewer> came from a discussion with <team members>

* The code in class <Viewer> uses an idea suggested by <previous assignment>

Signed: Haoyan Liu (u6720989)

#### Originality statement C
We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:



Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)

#### Originality statement B
We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.


Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)

## Git Log
```
commit 34e0e6378455f542ca716274f602082f41226574
Author: Haoyan Liu <u6720989@anu.edu.au>
Date:   Fri May 24 01:23:34 2019 +1000

    presentation

commit 23aae7fe00012e3b72ac99efe335e77fa98542fd
Merge: cdbe973 f2fc9a3
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Fri May 24 00:33:20 2019 +1000

    update

commit cdbe97342030f8d4a50c815477c5880642d1f0e3
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Fri May 24 00:30:36 2019 +1000

    Update originality

commit f2fc9a3ddb4219b34b30aef2fb46952c4fef9571
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Thu May 23 23:37:15 2019 +1000

    Update D2G files.

commit c64228aeafdb6c7cac6e6893d7efe7078710e4f8
Author: u6720989 <u6720989@anu.edu.au>
Date:   Thu May 23 23:05:41 2019 +1000

    Admin Bob

commit a8fb962c5dd5894601b720f5c728f934fb0414ee
Merge: af11db4 04f684f
Author: u6720989 <u6720989@anu.edu.au>
Date:   Thu May 23 22:57:53 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit af11db4dd739c828e918428cded56ced9d6da11f
Author: u6720989 <u6720989@anu.edu.au>
Date:   Thu May 23 22:56:42 2019 +1000

    Admin Bob

commit 04f684f984f07663bfd777416594392ab74165ce
Merge: 16516a5 bfad413
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Thu May 23 21:52:20 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 16516a57dd205f111187fbca318db9fa049e3000
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Thu May 23 21:51:48 2019 +1000

    Finished D2G files.

commit bfad413682ee2d174a3b1bb800bb392048ad9e1e
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 23 21:39:27 2019 +1000

    Update

commit 2ec33a49dfcacb119cd251fd431536fc67554ba6
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 23 21:35:40 2019 +1000

    Update game.jar

commit d1c5327296b493167eb549f84948849d2a0200dd
Merge: 5002130 45e7791
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Thu May 23 21:25:38 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 500213099a6d460b64295fef729f7e5960fe316a
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Thu May 23 21:23:17 2019 +1000

    update

commit 45e7791fd17a714660db86deace1446d240e9312
Author: u6720989 <u6720989@anu.edu.au>
Date:   Thu May 23 19:17:10 2019 +1000

    Admin Bob

commit 806fd03ff02cfd095bd279966519343896973ccf
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 23 14:39:27 2019 +1000

    make game.jar

commit 1ea203ae49d4fded4dfdfbda4be77f820218c41a
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 23 14:28:36 2019 +1000

    fix scroll bug

commit 3aace3e07e01ebc5851a04bd557b2b4d7bb374bd
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 23 13:29:28 2019 +1000

    Update

commit bb1cdfa26a9685cd2d09dec3a25138a73e4bded9
Merge: 1c5057b c768045
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Wed May 22 14:49:55 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 1c5057b4ef590fa5116576822fed85f1f164b4cf
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Wed May 22 14:49:42 2019 +1000

    Add some comments

commit c7680452c4500aa906e53d9ec9a6a4a9ff2a627f
Author: u6720989 <u6720989@anu.edu.au>
Date:   Wed May 22 14:40:34 2019 +1000

    Admin Bob

commit afc51fd209c1ecf9d5d0767f4b82b1613e8563a6
Author: u6720989 <u6720989@anu.edu.au>
Date:   Wed May 22 14:19:24 2019 +1000

    Admin Bob

commit 6022f5c2e2dc9075d90e7169fce67accffbfc42a
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Wed May 22 12:16:18 2019 +1000

    Update G-best

commit fbd6b44ca60c2b59860403b1d219435e9c6a3234
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Wed May 22 12:09:10 2019 +1000

    Add comments and refactor codes

commit 5a753e78a7c132c34d64c3f8b189ffbd9a7dadc2
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Tue May 21 19:19:58 2019 +1000

    Update efficiency task 10

commit a1ec6e4f16c8e241839ecb21c4f25d9e1be787b9
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue May 21 12:43:03 2019 +1000

    Fix a bug in the method findLongestRoad

commit 212d84e82f41a59f0f317bd2c5fd0b9bd3f35d3e
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 20 14:47:11 2019 +1000

    Fix bugs special tiles may used more than three for AI

commit 7721392405b2391348791ab27414c43a774f471b
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 20 05:39:53 2019 +1000

    Finish task 13 and improve code structure

commit 4039b0189300b85ffc7c6d58215cf7383de56f9a
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sun May 19 19:23:04 2019 +1000

    Fix

commit f4fa1b59d8b44823935a915947172df5fc5dce99
Author: u6720989 <u6720989@anu.edu.au>
Date:   Sun May 19 17:31:19 2019 +1000

    Task 13

commit 41681978fa3ed2b71d7b997a81c5e12cc5d4f1d7
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sun May 19 17:00:10 2019 +1000

    Update skeleton for task13

commit e6f073b0fdc1c739cf2695540bb40be206c5df48
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sun May 19 16:38:34 2019 +1000

    remove tiles

commit 0b0689d43c0509c64c0b34b498393b9a1d9cb594
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Thu May 16 04:08:35 2019 +1000

    Fix bugs and add new mode in Viewer, Refactor helper methods

commit 1cabc127ff830b2fd610a4b1a883377a7ff99495
Merge: 0de29b4 0856292
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Wed May 15 21:17:33 2019 +1000

    merge

commit 0de29b418b3dd4ea267f66f3c763003c63043c4d
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Wed May 15 21:17:02 2019 +1000

    update

commit 08562929d3763c18f22eb827c2589fe5415cfb16
Author: u6720989 <u6720989@anu.edu.au>
Date:   Wed May 15 21:14:33 2019 +1000

    search bob for all new update

commit 5d4aa43c3600c50620fbe3b64b4ffcfde52faf31
Merge: 79b5dd7 a73baf2
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 14 10:43:21 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit a73baf28d7b6360520b921efc4b383c8ed868ff0
Author: Haoyan Liu <u6720989@anu.edu.au>
Date:   Tue May 14 09:03:08 2019 +1000

    Update F-review-u6720989.md

commit 79b5dd7d068c805c451853d8e13870ae04baa9f6
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 14 08:53:58 2019 +1000

    Haoyan Liu

commit f6738cb95d43b707b17469450bf2067d17dddbf0
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue May 14 01:07:25 2019 +1000

    Update debug mode

commit 483c5110fec161305384a9970d605fd608c12628
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue May 14 00:30:58 2019 +1000

    Update Code Review

commit e2a2ba4d8bc6f7a733b1a4d1d7a42a4de2a04ffe
Merge: d22a207 73746ad
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 20:53:18 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit d22a2076ecc6a12a7dbc0402cd4cce98e96d973f
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 20:53:04 2019 +1000

    Haoyan Liu

commit 574f824a635208428df43fff7a1793af06f84c0f
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 20:51:32 2019 +1000

    Haoyan Liu

commit 73746add40e76bdb21e5bf3a0d1b8dcc1c2d5225
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon May 13 19:53:16 2019 +1000

    Finished D2F

commit 3dc2a82a548b652bd36c73ad7d533bc36a37f62c
Merge: 89708be af68f5d
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Mon May 13 19:49:55 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 89708be43476cfabdf6fbfbe6f321a958170b12f
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon May 13 19:49:38 2019 +1000

    Update the review task.

commit af68f5d1a44627886349b8fdca1a30cd80a9af7d
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 18:59:23 2019 +1000

    Haoyan Liu

commit bd73888241dcc365d305c3f5f2aa06c9a5508e09
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 17:36:42 2019 +1000

    Haoyan Liu

commit 39aa8e806128fef4f10b891bc898b173aae1c2a6
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 13 17:18:34 2019 +1000

    upadate MANIFEST.MF

commit 57747fe0483cbe5ed8eca5b6e5b7ecc588ad0833
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 13 17:16:49 2019 +1000

    Update game.jar

commit 202268c928686617949ba018f3cc536552168b50
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 13 17:14:07 2019 +1000

    Update originality

commit bd7ec93ee0dbf1a74df70c1819b8cf6a2104aebb
Merge: 5d6c4db 5bc8ee3
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 13 17:03:54 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 5d6c4db7d9415523400e59e6c35abd490c719961
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 13 17:03:49 2019 +1000

    add some comments

commit 5bc8ee3684d0fdd3f99900a837d399319bdd3d55
Author: u6720989 <u6720989@anu.edu.au>
Date:   Mon May 13 17:02:39 2019 +1000

    Haoyan Liu

commit 89b0a8dda9636eb89071ca0b8fbd326244420285
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Sun May 12 19:37:44 2019 +1000

    Update review comments

commit bece0a0cb6e45228e0742ea4571d0d3260aa3ba0
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Sun May 12 19:34:10 2019 +1000

    add game.jar

commit 2eaad05debf5bda54cd6719760315fed6ce497f8
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sun May 12 18:29:50 2019 +1000

    add args to Viewer.main

commit 33d1afa849b02239afb8e7891711351bb8035375
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sun May 12 03:27:15 2019 +1000

    Update review and modified some methods

commit 5a5d46fa878ca00998e197a90d8937f75a60daf4
Merge: a19af45 d33184e
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Sat May 11 22:43:14 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit a19af455af672c06152748d0748a2b6b26836284
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Sat May 11 22:42:42 2019 +1000

    Update the method of task 8

commit d33184e04b7f7341be27bf20e7a69f83e6af45f3
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sat May 11 17:34:11 2019 +1000

    Remove unused methods

commit 4b29d879588ee86885e4cb3d3a1611063b7b7250
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Fri May 10 00:14:35 2019 +1000

    update the state when finishes

commit fc1f5758551832699b1402e37430b536623e7305
Merge: d972bbb 5cc4487
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Thu May 9 00:31:16 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 5cc448733278de86218c9944959e10b73d690ea9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu May 9 00:26:38 2019 +1000

    fix chi-squared test values

commit d972bbbed3e6ca127afb6b5dcd21e27773d6c42d
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Wed May 8 17:00:52 2019 +1000

    Add some comments

commit 43095cd67db4250b19a76329163365a4ea3dbb50
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Wed May 8 11:21:47 2019 +1000

    Update method in task 7 for uniformly random distribution

commit 91ace5ddbef42ab302823292f2efb27b4e0cdc3e
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Wed May 8 10:42:17 2019 +1000

    update according to the test

commit e5d2951d8fadd681ebe809bb48a856e763f6719b
Merge: 6e11445 8363816
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Wed May 8 10:21:11 2019 +1000

    Merge remote-tracking branch 'upstream/master'

commit 6e11445b7f6196c1807a384087aba9c7f1cd13b7
Author: Frederick <u6527752@anu.edu.au>
Date:   Wed May 8 10:20:42 2019 +1000

    Finish task 11

commit 83638167f37ebcc8b4ba7857a67b38c1857f9d47
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 09:51:54 2019 +1000

    improve GenerateDiceRollTest to be statistically more rigorous
    
    added more tests for invalid placements due to duplicates

commit f6998e646dc7b8d48abb21808d8c2acdf7141aae
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 08:19:25 2019 +1000

    isValidPlacementSequenceTest: fix and add test for invalid connection
    
    add test for duplicate placements

commit 5e60063920c2d02815be64226485b60d88b71c23
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Tue May 7 09:32:06 2019 +1000

    Finish stageE and update originality
    
    (cherry picked from commit 62bb40e031d142cb545cf2c28a0efacc78cf9db0)

commit 79800062077023f0e7048fa6ba5446f286ce53e9
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon May 6 16:21:19 2019 +1000

    Finish stageE and update originality
    
    (cherry picked from commit 62bb40e031d142cb545cf2c28a0efacc78cf9db0)

commit 80055b4d845cfa0ba424301f9eb875c0ee5092dd
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Tue May 7 09:11:04 2019 +1000

    Update

commit 96ac7aa44d348d2ebf03b7ff860cb7468b238277
Merge: 62f06b6 47b0719
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue May 7 09:09:27 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 47b071969a6d200e54a0c2cfd913f9226c59cc7c
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 7 09:08:01 2019 +1000

    Haoyan Liu Originality

commit 34f42cc3b198c047ba9b5c5f4e06d32434aff09a
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 7 08:14:10 2019 +1000

    Bob 455

commit 9b0f83ca4edcda910543847fe6a262083dbd2205
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 7 07:55:27 2019 +1000

    Bob test

commit 55e7712c6a713d437aec6de204fb07ae1d1d0ed2
Merge: a32ca02 4fbf5b0
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 7 07:46:04 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Viewer.java

commit a32ca02875d290b35fbf0399743912ff2766a498
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue May 7 07:44:43 2019 +1000

    ADD C

commit 4fbf5b011ea98443b919007742766c1f3f6a9378
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon May 6 21:47:02 2019 +1000

    Finished GetOrientationsTest!

commit 62f06b6ca5daa7e3cc76d037711023c4c04a1811
Merge: 62bb40e 20f94fc
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon May 6 16:22:07 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 62bb40e031d142cb545cf2c28a0efacc78cf9db0
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon May 6 16:21:19 2019 +1000

    Finish stageE and update originality

commit d599d197355fa7d1ba8f1c0552497dd497193185
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Mon May 6 13:23:14 2019 +1000

    Finish task 12

commit 20f94fc800715ea7183ddbd6f90ebc0fd31459b0
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:50:23 2019 +1000

    remove unused code

commit b953060a4dd8bf37489323395d6cff489c72ced8
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:49:17 2019 +1000

    fix GenerateDiceRollTest.testDieFaces to correctly count dice rolls

commit fe3663392d2dd2cf58e0e94d98ae0a8e5673e92f
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Sat May 4 21:16:46 2019 +1000

    Update Viewer of S tiles rule

commit 1e684c9d3a4a6dd6e469bea4abd3497c42ebf9d6
Author: Frederick Li <u6527752@anu.edu.au>
Date:   Fri May 3 21:37:09 2019 +1000

    Organize helper functions and master tests

commit 6142576511cbe840e7c4643db0fd971204e9cc2a
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue Apr 30 00:18:43 2019 +1000

    ADD C

commit 5d08b888381a9bc54bccb62e2c11c2d146b13e97
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Mon Apr 29 21:37:00 2019 +1000

    Updated D-originality-u6502811

commit 1ca8b542cc81be00cbaa5acabb570830b54cfcce
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Apr 29 20:22:16 2019 +1000

    Update originality u6527752

commit 6c73c2077b2634d87e35d9aa924d01e657379445
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Apr 29 17:11:07 2019 +1000

    Update task 9

commit e0ee7e5ca46aba1faf0aa00b0ccaca223cb7c686
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Apr 29 13:56:17 2019 +1000

    Finish task 9

commit 767a4b7f2e50c37522435a01ce58a5d88d3f01dc
Author: Frederick <u6527752@anu.edu.au>
Date:   Fri Apr 26 10:22:46 2019 +1000

    Changes to Task 8

commit ba4f3d6c645ec1afcc31b6bca21fa039969fc304
Author: Frederick <u6527752@anu.edu.au>
Date:   Wed Apr 24 11:28:50 2019 +1000

    Part of task9

commit e2b50160a8dde569429bfe58dbc6a337acb071f7
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Apr 22 19:11:40 2019 +1000

    Update originality-u6527752

commit 2491bc55f8f7086349c8840aa9297e5519919ab6
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Apr 22 05:59:22 2019 +1000

    Finish task 10.

commit 622af471fd58b9a6059199935ba2aef3532a0e02
Author: Frederick <u6527752@anu.edu.au>
Date:   Wed Apr 17 03:53:04 2019 +1000

    Finish task 7 and task 8.

commit e08612f17b8340884c9215a827072489e225ad1d
Merge: 92d9daf 294083c
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue Apr 16 20:19:24 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 92d9daf1c3eba3f7529bd5e8e400c6e0c1599ea9
Merge: 97ac9c3 9cee2b5
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue Apr 16 20:19:12 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 294083c3b269a3e5fbe05d16c11ef3669c667ed6
Author: Chunhao Li <u6527752@anu.edu.au>
Date:   Tue Apr 2 09:44:45 2019 +1100

    add main to view

commit 9cee2b5b00726f2f206ecd616012ddcc36018c90
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 2 09:12:01 2019 +1100

    AreConnectedNeighboursTest: more tests for mirror-asymmetric tiles

commit 97ac9c31db4388acebecea2b5aad14642d1e4f02
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 22:30:13 2019 +1100

    Finish all

commit f0ed5ea67256df54c6b0785c27450a490fee4489
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon Apr 1 22:25:32 2019 +1100

    Changed Task4

commit dd8af5f2407ead6706dbc660d2eab86b112b0cd5
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 21:02:31 2019 +1100

    Add exits to board

commit 659ca620efdfcc06038fa93ca838d0a1ebeeae24
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 20:59:45 2019 +1100

    Add exits to board

commit 533de5e19f07eba09bb75f1cb056bb1868496ec8
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 19:54:17 2019 +1100

    Change setLayout in Viewer

commit 60f89054f533e0dd109a97f3e96bc0de582bbed9
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 18:10:31 2019 +1100

    update task2

commit cbde3ed24d571c928fc95db0b618a69bd9fc0df2
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 17:49:56 2019 +1100

    update task2

commit 31c272e3c809f2c8738982d4b7c414974fa6e19d
Merge: fe464a4 c31ba1e
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Apr 1 17:49:26 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit fe464a4479e2ff12f233d217e714b6db6e4cd2df
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon Apr 1 15:01:57 2019 +1100

    Finished Task4!

commit aa34871f4725dd638241263a763f50597c0072f7
Author: Frederick <u6527752@anu.edu.au>
Date:   Sun Mar 31 20:54:30 2019 +1100

    Polish codes

commit 8793931620e27fc06c113ed4755941af84e7a569
Author: Frederick <u6527752@anu.edu.au>
Date:   Sun Mar 31 18:47:52 2019 +1100

    finish task6

commit a94882d29785f4dca2830c0ca1fbbed3681869a3
Author: Frederick <u6527752@anu.edu.au>
Date:   Sun Mar 31 18:25:16 2019 +1100

    task 5 and part of task 6

commit c31ba1ef10ecf073353dddfbfd2bb72343c6c495
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 31 08:54:35 2019 +1100

    T10 GenerateMoveTest

commit 5a0302f1af1a21b7302a7be2b7061203f7531b48
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 22:39:34 2019 +1100

    T8 GetBasicScoreTest, T12 GetAdvancedScoreTest

commit 3d3d58e6aad2397b29a1c3a280b2e084cb5080bd
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sat Mar 30 17:00:42 2019 +1100

    task 1

commit d61559a8eace9eb0de8948899ccf1a333a7a43eb
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 14:39:59 2019 +1100

    test more types of invalid piece placements

commit cb9cecfc56a535eb777f9851c5be55bd8be5c874
Merge: 448ea10 87f0a67
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Sat Mar 30 03:01:50 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 448ea1042522add0c0837111b6545f6eb6e6d5df
Author: Frederick <u6527752@anu.edu.au>
Date:   Sat Mar 30 03:01:23 2019 +1100

    task 1

commit 537f1c801e82230b85840b9ae7e83897f7341bc8
Merge: b284bf5 97499e1
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue Mar 26 10:41:23 2019 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/gittest/Main.java

commit 97499e1c977d6900b8ec128a952495d41dad7068
Merge: f28a660 3292f51
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Tue Mar 26 10:39:12 2019 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/gittest/Main.java

commit f28a6607824601a667a731dc54ad2fa12b74a4dd
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:37:45 2019 +1100

    Change Main

commit 3292f519190916bc312a7426f062c07ccb403d3c
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue Mar 26 10:36:45 2019 +1100

    Change main

commit 2540dbfbe2f03c467d90f42ff06ea4de94d8c086
Merge: 1fa706a 8ff6cbd
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Tue Mar 26 10:35:07 2019 +1100

    Merge remote-tracking branch 'origin/master'

commit 8ff6cbd86b6abfe8ec3bcc52fe77f1eb0803ef0e
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue Mar 26 10:34:37 2019 +1100

    Change main

commit 1fa706a00250dd16b64be660ac6ee25770f6c71e
Merge: 4c7ac9f 03df45a
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Tue Mar 26 10:34:08 2019 +1100

    Merge branch 'BobsExperiment' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 4209c633893fbd88749aa8b76444f715d5dc5856
Merge: 4c7ac9f 03df45a
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Tue Mar 26 10:33:51 2019 +1100

    Merge branches 'BobsExperiment' and 'master' of https://gitlab.cecs.anu.edu.au/u6527752/comp1110-ass2-tue09a

commit 4c7ac9fb55acf8202ea6588036a2138123290977
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:32:50 2019 +1100

    Add new B

commit 670f04af3161aaa3de85197e036d7da422398473
Merge: e2467cc 669062d
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Tue Mar 26 10:32:09 2019 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/gittest/Main.java

commit e2467cc0580652ef84335ce91be58a6b6bd77b92
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:31:41 2019 +1100

    Add new B

commit b284bf54a1ba278cc635814c61f89a2e23c753ee
Author: u6720989 <u6720989@anu.edu.au>
Date:   Tue Mar 26 10:31:34 2019 +1100

    ADD C

commit 669062d302d84aa7e455c69c84dc924f0d1f5e7e
Author: Frederick <u6527752@anu.edu.au>
Date:   Tue Mar 26 10:31:16 2019 +1100

    Change main

commit 03df45aabea3618fb7040af5f0a47941706f6016
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:28:04 2019 +1100

    Change B 2

commit 865e49974857fe3f05cc1b48dd91bbbd02fda878
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:27:46 2019 +1100

    Change B 1

commit b2eadfac741f4be0982bee9228c4fdbcfba9be26
Merge: f66a7fe 9ae5d7a
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Tue Mar 26 10:24:53 2019 +1100

    Merge remote-tracking branch 'origin/master'

commit 9ae5d7a385750c7cf279144a8a5f2873b00af1ea
Author: Haoyan Liu <u6720989@anu.edu.au>
Date:   Tue Mar 26 10:24:29 2019 +1100

    ADD C

commit f66a7fe1557f7728746e6c273bf399e86c30bc6a
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Tue Mar 26 10:21:52 2019 +1100

    Add B

commit deac1dbc5f59a08dc67b1146a463a01947dad60a
Author: Frederick <u6527752@anu.edu.au>
Date:   Tue Mar 26 10:20:02 2019 +1100

    Update B-originality

commit 401fad5e2339f2715d09cd866a749acc33b70533
Author: Frederick <u6527752@anu.edu.au>
Date:   Tue Mar 26 01:37:42 2019 +1100

    Update B-originality

commit 7d562bcd073adaf35a68b0e6a01bf7e27760c6cb
Author: Haoyan Liu <u6720989@anu.edu.au>
Date:   Mon Mar 25 22:58:59 2019 +1100

    Update B-contribution.md

commit 3b430eacf5becda1f5c00c4ab62b95e7016e3f0e
Author: Mingchao Sima <Mingchao.Sima@anu.edu.au>
Date:   Mon Mar 25 22:37:32 2019 +1100

    Changed B-contribution

commit 39473582b412f853bac2ad96db48032610a1bba9
Author: Mingchao Sima <mingchao.sima@anu.edu.au>
Date:   Mon Mar 25 21:19:33 2019 +1100

    Signed in B-originality

commit b05d69ac08ab2570865a03b68ecf3e529e90babd
Author: Mingchao <u6502811>
Date:   Mon Mar 25 21:18:01 2019 +1100

    Signed in B-Contribution

commit 1e9da6a5a0dca78548c34badaf19a9aff3eaa312
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Mar 25 16:27:33 2019 +1100

    Update B-originality

commit 7fa1c9c744b655efdb5e696d3911579295f0f4ad
Author: Frederick Li <creanfrederick@gmail.com>
Date:   Mon Mar 25 16:23:39 2019 +1100

    Basic skeleton

commit 2ab8fd380f4f30379ef81709c5fe4a519cb44e4f
Author: Frederick <u6527752@anu.edu.au>
Date:   Mon Mar 25 11:24:06 2019 +1100

    Signed in B-contribution and B-originality

commit 87f0a67a1ea2b01ea570f9cbe66f23eacfe13a1c
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Mar 22 16:57:27 2019 +1100

    fix off-by-one errors in Javadoc spec

commit 6899cf1bfb33883edba7d29b261aa2e63950d6be
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Mar 21 21:40:31 2019 +1100

    fix specification for dice roll - B can only roll 0-2
    
    fix IsTilePlacementWellFormedTest and GenerateDiceRollTest accordingly

commit 984e9fef1b9f26e2d4f38cf136ad5e85b4a9a6cd
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 19 02:08:41 2019 +1100

    assignment published
```
## Changes
``` diff
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.md comp1110-ass2/admin/B-contribution.md
--- ../master/comp1110-ass2/admin/B-contribution.md	2019-05-24 13:59:03.704392235 +1000
+++ comp1110-ass2/admin/B-contribution.md	2019-05-24 14:01:16.281186415 +1000
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6527752 40
+* u6502811 30
+* u6720989 30
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.md comp1110-ass2/admin/B-originality.md
--- ../master/comp1110-ass2/admin/B-originality.md	2019-05-24 13:59:03.724392356 +1000
+++ comp1110-ass2/admin/B-originality.md	2019-05-24 14:01:16.313186606 +1000
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.md comp1110-ass2/admin/C-contribution.md
--- ../master/comp1110-ass2/admin/C-contribution.md	2019-05-24 13:59:03.740392452 +1000
+++ comp1110-ass2/admin/C-contribution.md	2019-05-24 14:01:16.333186726 +1000
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage C was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6527752 40
+* u6502811 30
+* u6720989 30
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.md comp1110-ass2/admin/C-originality.md
--- ../master/comp1110-ass2/admin/C-originality.md	2019-05-24 13:59:03.768392620 +1000
+++ comp1110-ass2/admin/C-originality.md	2019-05-24 14:01:16.349186821 +1000
@@ -1,9 +1,5 @@
 We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
 
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Chunhao Li (u6527752), Mingchao Sima (u6502811), and Haoyan Liu (u6720989)
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.md
Only in comp1110-ass2/admin: D-originality-u6502811.md
Only in comp1110-ass2/admin: D-originality-u6527752.md
Only in comp1110-ass2/admin: D-originality-u6720989.md
Only in ../master/comp1110-ass2/admin: E-originality-u1234567.md
Only in comp1110-ass2/admin: E-originality-u6502811.md
Only in comp1110-ass2/admin: E-originality-u6527752.md
Only in comp1110-ass2/admin: E-originality-u6720989.md
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.md comp1110-ass2/admin/F-contribution.md
--- ../master/comp1110-ass2/admin/F-contribution.md	2019-05-24 13:59:03.852393125 +1000
+++ comp1110-ass2/admin/F-contribution.md	2019-05-24 14:01:16.509187777 +1000
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage F was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6720989 15
+* u6527752 70
+* u6502811 15
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Haoyan Liu (u6720989), Chunhao Li(u6527752), and Mingchao Sima (u6502811)
 
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.md comp1110-ass2/admin/F-originality.md
--- ../master/comp1110-ass2/admin/F-originality.md	2019-05-24 13:59:03.884393317 +1000
+++ comp1110-ass2/admin/F-originality.md	2019-05-24 14:01:16.533187920 +1000
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Chunhao Li (u6527752), Haoyan Liu (u6720989), and Mingchao Sima (u6502811)
Only in ../master/comp1110-ass2/admin: F-review-u1234567.md
Only in comp1110-ass2/admin: F-review-u6502811.md
Only in comp1110-ass2/admin: F-review-u6527752.md
Only in comp1110-ass2/admin: F-review-u6720989.md
Only in ../master/comp1110-ass2/admin: G-best-u1234567.md
Only in comp1110-ass2/admin: G-best-u6502811.md
Only in comp1110-ass2/admin: G-best-u6527752.md
Only in comp1110-ass2/admin: G-best-u6720989.md
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.md comp1110-ass2/admin/G-contribution.md
--- ../master/comp1110-ass2/admin/G-contribution.md	2019-05-24 13:59:04.000394015 +1000
+++ comp1110-ass2/admin/G-contribution.md	2019-05-24 14:01:16.717189018 +1000
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6720989 25
+* u6527752 50
+* u6502811 25
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Chunhao Li (u6527752), Haoyan Liu (u6720989), and Mingchao Sima (u6502811)
 
diff -ru -x .git ../master/comp1110-ass2/admin/G-features.md comp1110-ass2/admin/G-features.md
--- ../master/comp1110-ass2/admin/G-features.md	2019-05-24 13:59:04.028394183 +1000
+++ comp1110-ass2/admin/G-features.md	2019-05-24 14:01:16.737189138 +1000
@@ -1,7 +1,6 @@
 In addition to the features that are auto-graded, the graphical user interface
 of our project implements the following features:
 
-*(Remove those that are unimplemented)*
 
  - A simple placement viewer (Task 4)
  - A basic playable game
@@ -9,5 +8,6 @@
  - Generates basic starting piece placements (Task 8)
  - Implements hints (Task 10)
  - Implements interesting starting placements (Task 11)
+ - Add AI to AI mode
+
 
-additional features...
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.md comp1110-ass2/admin/G-originality.md
--- ../master/comp1110-ass2/admin/G-originality.md	2019-05-24 13:59:04.048394304 +1000
+++ comp1110-ass2/admin/G-originality.md	2019-05-24 14:01:16.757189258 +1000
@@ -1,9 +1,4 @@
-We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Chunhao Li (u6527752), Haoyan Liu (u6720989), and Mingchao Sima (u6502811)
diff -ru -x .git ../master/comp1110-ass2/admin/H-contribution.md comp1110-ass2/admin/H-contribution.md
--- ../master/comp1110-ass2/admin/H-contribution.md	2019-05-24 13:59:04.068394424 +1000
+++ comp1110-ass2/admin/H-contribution.md	2019-05-24 14:01:16.785189424 +1000
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage H was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6720989 34
+* u6527752 33
+* u6502811 33
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Haoyan Liu (u6720989), Chunhao Li (u6527752), and Mingchao Sima (u6502811)
 
diff -ru -x .git ../master/comp1110-ass2/admin/H-originality.md comp1110-ass2/admin/H-originality.md
--- ../master/comp1110-ass2/admin/H-originality.md	2019-05-24 13:59:04.096394593 +1000
+++ comp1110-ass2/admin/H-originality.md	2019-05-24 14:01:16.809189567 +1000
@@ -1,10 +1,4 @@
-We declare that the work we have submitted for Stage H of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage H of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
 
+Signed: Haoyan Liu (u6720989), Chunhao Li (u6527752), and Mingchao Sima (u6502811)
diff -ru -x .git ../master/comp1110-ass2/admin/tasks.md comp1110-ass2/admin/tasks.md
--- ../master/comp1110-ass2/admin/tasks.md	2019-05-24 13:59:04.120394737 +1000
+++ comp1110-ass2/admin/tasks.md	2019-05-24 14:01:16.829189687 +1000
@@ -5,15 +5,13 @@
 
 ## Week 4
 
-Everyone: create application skeleton - meeting 14:00 17 Aug
+Everyone: create application skeleton - meeting 14:00 23 Mar
 
 ## Week 5
 
-Zhang San: Task 3 isPiecePlacementWellFormed - 21 Aug
+Haoyan liu: Finish Task 5 with Chunhao Li. Provide my own idea about the whole first Part. 
 
-Jane Bloggs: Task 4 getNeighbours - 23 Aug
-
-Erika Mustermann: Task 6 getViablePiecePlacements - 24 Aug (depends on Task 3)
+Mingchao Sima: Finished Task 4 and drawExits method improved by Chunhao Li.
 
 ## Week 6
 
@@ -26,7 +24,17 @@
 ## Week 8
 
 ## Week 9
+Haoyan Liu: Complete task 7 . Create a version of Task10 with Mingchao Sima.  Add some comment in RailroadLink.
 
-## Week 10
+Mingchao Sima: Help Haoyan Liu to complete and improve Task 10.
 
+## Week 10
+Haoyan Liu: Improve javaFX based on the previous work of Chunhao li.
+            Try task13 , upload a poor version . Add some comment on RailRoadLink.
+            
+Mingchao Sima: Improved the countExitScore method based on the work of Chunhao Li.
+            
 ## Week 11
+Haoyan Liu: Review the whole assignment. Do some simple adjustment.
+
+Mingchao Sima: Discussed the questions in the whole assignment 2 with all and the presentation.
diff -ru -x .git ../master/comp1110-ass2/comp1110-ass2.iml comp1110-ass2/comp1110-ass2.iml
--- ../master/comp1110-ass2/comp1110-ass2.iml	2019-05-24 13:59:04.500397021 +1000
+++ comp1110-ass2/comp1110-ass2.iml	2019-05-24 14:01:17.177191764 +1000
@@ -8,7 +8,7 @@
     </content>
     <orderEntry type="inheritedJdk" />
     <orderEntry type="sourceFolder" forTests="false" />
-    <orderEntry type="module-library" scope="TEST">
+    <orderEntry type="module-library" exported="" scope="TEST">
       <library name="JUnit4">
         <CLASSES>
           <root url="jar://$APPLICATION_HOME_DIR$/lib/junit-4.12.jar!/" />
@@ -18,6 +18,7 @@
         <SOURCES />
       </library>
     </orderEntry>
-    <orderEntry type="library" name="javafx" level="project" />
+    <orderEntry type="library" exported="" name="lib" level="project" />
+    <orderEntry type="library" exported="" name="javafx" level="project" />
   </component>
 </module>
\ No newline at end of file
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2/.idea: artifacts
diff -ru -x .git ../master/comp1110-ass2/.idea/libraries/javafx.xml comp1110-ass2/.idea/libraries/javafx.xml
--- ../master/comp1110-ass2/.idea/libraries/javafx.xml	2019-05-24 13:59:03.420390528 +1000
+++ comp1110-ass2/.idea/libraries/javafx.xml	2019-05-24 14:01:15.929184314 +1000
@@ -4,6 +4,9 @@
       <root url="file://$PATH_TO_FX$" />
     </CLASSES>
     <JAVADOC />
+    <NATIVE>
+      <root url="file://$PATH_TO_FX$" />
+    </NATIVE>
     <SOURCES>
       <root url="file://$PATH_TO_FX$" />
     </SOURCES>
Only in comp1110-ass2/.idea/libraries: lib.xml
Only in comp1110-ass2/.idea: markdown-navigator
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T10_GenerateMoveTest.xml comp1110-ass2/.idea/runConfigurations/T10_GenerateMoveTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T10_GenerateMoveTest.xml	2019-05-24 13:59:03.476390864 +1000
+++ comp1110-ass2/.idea/runConfigurations/T10_GenerateMoveTest.xml	2019-05-24 14:01:16.033184936 +1000
@@ -3,14 +3,13 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.GenerateMoveTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T12_GetAdvancedScoreTest.xml comp1110-ass2/.idea/runConfigurations/T12_GetAdvancedScoreTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T12_GetAdvancedScoreTest.xml	2019-05-24 13:59:03.488390936 +1000
+++ comp1110-ass2/.idea/runConfigurations/T12_GetAdvancedScoreTest.xml	2019-05-24 14:01:16.053185054 +1000
@@ -3,14 +3,13 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.GetAdvancedScoreTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T3_IsBoardStringWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/T3_IsBoardStringWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T3_IsBoardStringWellFormedTest.xml	2019-05-24 13:59:03.516391104 +1000
+++ comp1110-ass2/.idea/runConfigurations/T3_IsBoardStringWellFormedTest.xml	2019-05-24 14:01:16.089185269 +1000
@@ -3,17 +3,16 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.IsBoardStringWellFormedTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T5_AreConnectedNeighboursTest.xml comp1110-ass2/.idea/runConfigurations/T5_AreConnectedNeighboursTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T5_AreConnectedNeighboursTest.xml	2019-05-24 13:59:03.588391538 +1000
+++ comp1110-ass2/.idea/runConfigurations/T5_AreConnectedNeighboursTest.xml	2019-05-24 14:01:16.101185342 +1000
@@ -3,17 +3,16 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.AreConnectedNeighboursTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T6_IsValidPlacementSequenceTest.xml comp1110-ass2/.idea/runConfigurations/T6_IsValidPlacementSequenceTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T6_IsValidPlacementSequenceTest.xml	2019-05-24 13:59:03.620391731 +1000
+++ comp1110-ass2/.idea/runConfigurations/T6_IsValidPlacementSequenceTest.xml	2019-05-24 14:01:16.117185437 +1000
@@ -3,17 +3,16 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.IsValidPlacementSequenceTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T7_GenerateDiceRollTest.xml comp1110-ass2/.idea/runConfigurations/T7_GenerateDiceRollTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T7_GenerateDiceRollTest.xml	2019-05-24 13:59:03.636391826 +1000
+++ comp1110-ass2/.idea/runConfigurations/T7_GenerateDiceRollTest.xml	2019-05-24 14:01:16.133185533 +1000
@@ -3,17 +3,16 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.GenerateDiceRollTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/T8_GetBasicScoreTest.xml comp1110-ass2/.idea/runConfigurations/T8_GetBasicScoreTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/T8_GetBasicScoreTest.xml	2019-05-24 13:59:03.652391922 +1000
+++ comp1110-ass2/.idea/runConfigurations/T8_GetBasicScoreTest.xml	2019-05-24 14:01:16.149185628 +1000
@@ -3,14 +3,13 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="mytest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
     <option name="PACKAGE_NAME" value="comp1110.ass2" />
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.GetBasicScoreTest" />
     <option name="METHOD_NAME" value="" />
-    <option name="TEST_OBJECT" value="class" />
     <option name="PARAMETERS" value="" />
     <method v="2">
       <option name="Make" enabled="true" />
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml comp1110-ass2/.idea/runConfigurations/Viewer.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 13:59:03.664391995 +1000
+++ comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 14:01:16.185185843 +1000
@@ -13,4 +13,4 @@
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
Only in comp1110-ass2: .nfs00000000502aaa18000001a7
Only in comp1110-ass2: .nfs00000000502aacf70000020a
Only in comp1110-ass2: .nfs00000000502fd26a000001b6
Only in comp1110-ass2: presentation.pdf
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: bg.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: BGM.mp3
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: boardBG.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: icon.png
Only in comp1110-ass2/src/comp1110/ass2/gui: GameBoardBG.css
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$DraggablePiece.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 13:59:04.616397720 +1000
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 14:01:20.077209074 +1000
@@ -1,70 +1,1047 @@
 package comp1110.ass2.gui;
 
+import static comp1110.ass2.RailroadInk.*;
+
 import javafx.application.Application;
+import javafx.beans.property.BooleanProperty;
+import javafx.beans.property.ReadOnlyBooleanWrapper;
+import javafx.geometry.Pos;
 import javafx.scene.Group;
+import javafx.scene.Node;
 import javafx.scene.Scene;
-import javafx.scene.control.Button;
-import javafx.scene.control.Label;
-import javafx.scene.control.TextField;
+import javafx.scene.control.*;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.input.KeyCode;
 import javafx.scene.layout.HBox;
+import javafx.scene.layout.VBox;
+import javafx.scene.media.Media;
+import javafx.scene.media.MediaPlayer;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Line;
+import javafx.scene.text.Font;
+import javafx.scene.text.Text;
 import javafx.stage.Stage;
 
+import java.util.ArrayList;
+import java.util.HashSet;
+import java.util.List;
+import java.util.Set;
+
 /**
- * A very simple viewer for tile placements in the Railroad Ink game.
+ * This is a JavaFX application that provides a graphical user interface for the Railroad Ink game.
  * <p>
- * NOTE: This class is separate from your main game class.  This
- * class does not play a game, it just illustrates various tile placements.
+ *
+ * @author Frederick Li (except explicitly commented)
+ *
+ * The game feature:
+ * - It has four modes (Single Mode), (Player to AI mode), (Debug Mode), (AI to AI mode) which correspond to
+ * -    the buttons "Single game", "Play with computer", "Debug mode", "AI to AI" in the main page.
+ * - In every mode, users can press "ESCAPE" to quit and clear current game state
+ * -    and go back to the main page.
+ * - In the main page, useres can press "Q" to quit the game.
+ *
+ * - Single Mode:
+ * -    Users can press "Roll a dice" to start a new turn, and press "clear" to end the current game
+ * -    Users can rotate the tiles using mouse scroll on tiles, flip the tiles when click twice on
+ * -        the tile or flip back with tripple click.
+ * -    Users can drag tiles and put them on the board.
+ * -    All other rules are in README.md.
+ * - Player to AI Mode:
+ * -    Most of the features are the same as the Single Mode.
+ * -    "Change to AI" button can enable AI to play moves.
+ * -    In every turn except turn 7, users need to press "Change to AI" which enables AI to make a move.
+ * -    Users can int score = getAdvancedScore(boardString);
+                            resultInfo = new Text(VIEWER_WIDTH / 2, 60,
+                                    "Total Score: " + score);
+                            resultInfo.setFont(Font.font("Verdana", 20));
+                            generatingPieces.getChildren().clear();
+                            group.getChildren().add(resultInfo); press "New Game" to end the current game and start a new one.
+ * -    Users can press "Change to AI" to change the board to AI's, and "Go back to player" to switch back
+ * -    All other rules are in README.md.
+ * - Debug Mode:
+ * -    Users can input any tile placements in the TextField and then press "Refresh" to show them
+ * -    When users input any illegal texts in the TextField, "Refresh" can clear the current tiles.
+ * -    "Place tiles" does the same thing except that it won't clear TextField.
+ * - AI to AI:
+ * -    A simple mode for testing different AIs' performance. Simpliy change the "generateMove"
+ * -    and "generateBetterMove" in the method playMoveAi for using different AI. (add or remove
+ * -    "sTilesAI" or "STileAicomponent" if the methods needs to use special tiles or not).
  */
 public class Viewer extends Application {
-    /* board layout */
-    private static final int VIEWER_WIDTH = 1024;
-    private static final int VIEWER_HEIGHT = 768;
-
+    private static final double VIEWER_WIDTH = 1024;
+    private static final double VIEWER_HEIGHT = 768;
     private static final String URI_BASE = "assets/";
+    private static final double Tile_Size = 80;
+    private static final int X_Side = 232;   //(VIEWER_WIDTH - Tile_Size * 7)/2
+    private static final int Y_Side = 104;   //(VIEWER_HEIGHT - Tile_Size * 7)/2
+
+    final private static MediaPlayer bgMusic        // Bob modified
+        = new MediaPlayer(new Media(Viewer.class.getResource(URI_BASE + "BGM.mp3").toString()));
+    final private static int MUSIC_MODE = MediaPlayer.INDEFINITE;  // Bob modified
+
+    private final Group mainGroup = new Group();
+    private final Group boardSingleMode = new Group(); // board group for single game mode
+    private final Group boardAI = new Group(); // AI in "Player to AI" or AI1 in "AI to AI" mode
+    private final Group boardPlayer = new Group();
+    private final Group boardAIComponent = new Group(); // AI2's board in "AI to AI" mode
+
+    private final Group controls = new Group(); // controls for "Single Mode" and "Debug Mode"
+    private final Group controlsPlayer = new Group();
+    private final Group controlsAI = new Group();  // AI's controls in "Player to AI"
+    private final Group controlsAIMode = new Group();   // AI1 in "AI to AI mode"
+    private final Group controlsAiComponent = new Group(); // AI2 in "AI to AI mode"
+    private final Group pieces = new Group();
+    private final Group placedPieces = new Group();
+    private final Group aiPieces = new Group();
+    private final Group generatingPieces = new Group();
+    private final Group rootSingle = new Group();
+    private final Group rootPlayer = new Group();
+    private final Group rootAI = new Group();   // main group for AI in "Player to AI" or AI1 in "AI to AI"
+    private final Group rootAIComponent = new Group();
+    private Scene sceneAIComponent = new Scene(rootAIComponent, VIEWER_WIDTH, VIEWER_HEIGHT);
+    private Scene sceneAI = new Scene(rootAI, VIEWER_WIDTH, VIEWER_HEIGHT);
+    private Scene sceneMain = new Scene(mainGroup, VIEWER_WIDTH, VIEWER_HEIGHT);
+    private Scene sceneSingle = new Scene(rootSingle, VIEWER_WIDTH, VIEWER_HEIGHT);
+    private Scene scenePlayer = new Scene(rootPlayer, VIEWER_WIDTH, VIEWER_HEIGHT);
+    private TextField textField;
+    private String boardString = "";
+    private String boardStringAI = "";
+    private int sTileTotal = 0;
+    private int sTilePerTurn = 0;
+    private List<DraggablePiece> sTilesNotPlaced = new ArrayList<>();
+    private String dices = "";
+    private String dicesAI = "";
+    private int diceRollTimes = 0;
+    private Text resultInfo = null;
+    private Text resultInfoAI = null;
+    private Text turnInfo = null;
+    private Text turnInfoAI = null;
+    private List<String> sTilesAI = new ArrayList<>();
+    private List<String> sTileAIComponent = new ArrayList<>();
 
-    private final Group root = new Group();
-    private final Group controls = new Group();
-    TextField textField;
+    //Bob modified
+    private ImageView mainBgImg;
+    private ImageView boardBGImg;
+    private ImageView aiGroupImg;
+    private ImageView aiComponentImg;
 
     /**
      * Draw a placement in the window, removing any previously drawn one
-     *
+     * @author Mingchao Sima, Frederick Li (modified)
      * @param placement A valid placement string
+     *
      */
-    void makePlacement(String placement) {
+    public void makePlacement(String placement, boolean isAIMode, Group group) {
         // FIXME Task 4: implement the simple placement viewer
+        group.getChildren().clear();
+        for (int i = placement.length() - 5; i >= 0; i -= 5) {
+            try {
+                ImageView tileImage = new ImageView(new Image(Viewer.class.getResource(
+                        URI_BASE + placement.substring(i, i + 2) + ".png").toString()));
+                tileImage.setFitWidth(Tile_Size);
+                tileImage.setFitHeight(Tile_Size);
+                tileImage.setLayoutY(Y_Side + (placement.charAt(i + 2) - 'A') * Tile_Size);
+                tileImage.setLayoutX(X_Side + (placement.charAt(i + 3) - '0') * Tile_Size);
+                int orientation = placement.charAt(i + 4) - '0';
+                if (orientation > 3) tileImage.setScaleX(-1);   // flip tile
+                tileImage.setRotate(orientation < 4 ? orientation * 90 : (orientation - 4) * 90);
+                group.getChildren().add(tileImage);
+            } catch (NullPointerException e) {  // invalid placement input
+                return;
+            }
+        }
+        if (isAIMode) {
+            dicesAI = "";
+        }
+    }
+
+
+    /**
+     * This method is used to draw 12 exits
+     *
+     * @param group a board Group which will add these exits
+     * @author Mingchao Sima
+     */
+    private void drawExits(Group group) {
+        for (int col = 0; col < 7; col++) {
+            for (int row = 0; row < 7; row++) {
+                ImageView exit = new ImageView();
+                exit.setFitWidth(Tile_Size);
+                exit.setFitHeight(Tile_Size);
+                if (col == 1 || col == 3 || col == 5) {
+                    exit.setLayoutX(X_Side + col * Tile_Size);
+                    if (col == 1 || col == 5) {
+                        exit.setImage(new Image(Viewer.class.getResource(
+                                URI_BASE + "HighExit.png").toString()));
+                    } else {
+                        exit.setImage(new Image(Viewer.class.getResource(
+                                URI_BASE + "RailExit.png").toString()));
+                    }
+
+                    if (row == 0) {
+                        exit.setLayoutY(Y_Side - Tile_Size / 2);
+                        group.getChildren().add(exit);
+                    } else if (row == 6) {
+                        exit.setRotate(180);
+                        exit.setLayoutY(VIEWER_HEIGHT - Y_Side - Tile_Size / 2);
+                        group.getChildren().add(exit);
+                    }
+
+                } else if (col == 0 || col == 6) {
+                    exit.setLayoutY(Y_Side + row * Tile_Size);
+                    if (col == 0) {
+                        exit.setRotate(270);
+                        exit.setLayoutX(X_Side - Tile_Size / 2);
+                    } else {
+                        exit.setRotate(90);
+                        exit.setLayoutX(VIEWER_WIDTH - X_Side - Tile_Size / 2);
+                    }
+
+                    if (row == 1 || row == 5) {
+                        exit.setImage(new Image(Viewer.class.getResource(
+                                URI_BASE + "RailExit.png").toString()));
+                        group.getChildren().add(exit);
+                    } else if (row == 3) {
+                        exit.setImage(new Image(Viewer.class.getResource(
+                                URI_BASE + "HighExit.png").toString()));
+                        group.getChildren().add(exit);
+                    }
+                }
+            }
+        }
+    }
+
+
+    /* Generate 4 normal tiles with random dice roll and 6 special tiles */
+    private void generateDicePieces(Group group) {
+        if (!dices.isEmpty() && hasValidPlacement(false)) {
+            Alert alert = new Alert(Alert.AlertType.WARNING,
+                    "You must place regular tiles as many as you can!");
+            alert.showAndWait();
+            return;
+        }
+        diceRollTimes++;
+        dices = generateDiceRoll();
+
+        if (diceRollTimes > 1) {
+            group.getChildren().remove(turnInfo); // avoid adding the same node twice
+        }
+        turnInfo = group == rootPlayer ?
+                new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes) :
+                new Text(X_Side + Tile_Size, 60, "Turn: " + diceRollTimes);
+        turnInfo.setFont(Font.font("Verdana", 20));
+        group.getChildren().add(turnInfo);
+
+        sTilePerTurn = 0;   // init special tiles used count
+        generatingPieces.getChildren().clear();
+
+        if (group == rootPlayer) {  // Player to AI mode
+            rootAI.getChildren().remove(turnInfoAI);
+            turnInfoAI = new Text(X_Side + Tile_Size, 60, "Turn: " + diceRollTimes);
+            turnInfoAI.setFont(Font.font("Verdana", 20));
+            rootAI.getChildren().add(turnInfoAI);
+            dicesAI = dices;
+        }
+
+        String[] tiles = splitString(dices, 2);
+
+        for (int i = 0; i < tiles.length; i++) {
+            String dice = tiles[i];
+            Image tileImage = new Image(Viewer.class.getResource(
+                    URI_BASE + dice + ".png").toString());
+            DraggablePiece draggablePiece = new DraggablePiece(tileImage, dice);
+            draggablePiece.setFitHeight(Tile_Size);
+            draggablePiece.setFitWidth(Tile_Size);
+            draggablePiece.homeX = X_Side / 3f;
+            draggablePiece.homeY = Y_Side + 20 + 2 * i * Tile_Size;
+            draggablePiece.setLayoutX(draggablePiece.homeX);
+            draggablePiece.setLayoutY(draggablePiece.homeY);
+            generatingPieces.getChildren().add(draggablePiece);
+        }
+
+        // draw the six special tiles in the first turn
+        if (diceRollTimes == 1) {
+            for (int i = 0; i < 6; i++) {
+                Image tileImage = new Image(Viewer.class.getResource(
+                        URI_BASE + "S" + i + ".png").toString());
+                DraggablePiece draggablePiece = new DraggablePiece(tileImage, "S" + i);
+                draggablePiece.setFitWidth(Tile_Size);
+                draggablePiece.setFitHeight(Tile_Size);
+                draggablePiece.homeX = X_Side + 7 * Tile_Size + X_Side / 3f;
+                draggablePiece.setLayoutX(draggablePiece.homeX);
+                draggablePiece.homeY = 30 + 1.5 * i * Tile_Size;
+                draggablePiece.setLayoutY(draggablePiece.homeY);
+                sTilesNotPlaced.add(draggablePiece);
+                generatingPieces.getChildren().add(draggablePiece);
+            }
+        } else {
+            generatingPieces.getChildren().addAll(sTilesNotPlaced);
+        }
+
+        handlePiece(group);
+    }
+
+
+    /**
+     * This class can enable users to drag or rotate tiles
+     */
+    class DraggablePiece extends ImageView {
+        double homeX, homeY;
+        int rotation = 0;
+        double mouseX, mouseY;  // the last known mouse positions
+        boolean isFlipped = false;
+        String name;
+
+        DraggablePiece(Image image, String name) {
+            super(image);
+            this.name = name;
+        }
+
+        private void snapToHome() {
+            this.setLayoutX(homeX);
+            this.setLayoutY(homeY);
+            this.setOpacity(1.0);
+        }
+
+        private void snapToGrid() {
+            double currX = this.getLayoutX();
+            double currY = this.getLayoutY();
+            double newX = Math.round((currX - X_Side) / Tile_Size) * Tile_Size + X_Side;
+            double newY = Math.round((currY - Y_Side) / Tile_Size) * Tile_Size + Y_Side;
+            this.setLayoutX(newX);
+            this.setLayoutY(newY);
+            this.setOpacity(1.0);
+        }
+
+        private void rotate() {
+            rotation = (rotation + 1) % 4;
+            this.setRotate(rotation * 90);
+        }
+
+        private void flipped() {
+            this.setScaleX(-1);
+            isFlipped = true;
+
+        }
+
+        private void flippedBack() {
+            this.setScaleX(1);
+            isFlipped = false;
+        }
+
+        void drag(double moveX, double moveY) {
+            setLayoutX(getLayoutX() + moveX);
+            setLayoutY(getLayoutY() + moveY);
+            setOpacity(0.5);
+            this.toFront();
+        }
+
+        boolean isOnBoard() {
+            return getLayoutX() > X_Side - Tile_Size && getLayoutX() < VIEWER_WIDTH - X_Side
+                    && getLayoutY() > Y_Side - Tile_Size && getLayoutY() < VIEWER_HEIGHT - Y_Side;
+        }
+
+        void setPosition() {
+            Image tileImage = new Image(Viewer.class.getResource(
+                    URI_BASE + name + ".png").toString());
+            ImageView placedPiece = new ImageView(tileImage);
+            placedPiece.setRotate(rotation * 90);
+            if (isFlipped) {
+                placedPiece.setScaleX(-1);
+            }
+            placedPiece.setFitHeight(Tile_Size);
+            placedPiece.setFitWidth(Tile_Size);
+            placedPiece.setLayoutX(this.getLayoutX());
+            placedPiece.setLayoutY(this.getLayoutY());
+            placedPieces.getChildren().add(placedPiece);
+            if (name.charAt(0) == 'S') {
+                sTilePerTurn++;
+                sTileTotal++;
+                sTilesNotPlaced.remove(this);
+            } else {
+                int i = dices.indexOf(name);
+                dices = dices.substring(0, i) + dices.substring(i+2, dices.length()); // remove from dices
+            }
+        }
+
+        boolean isValid() {
+            double currX = this.getLayoutX();
+            double currY = this.getLayoutY();
+            char col = (char) (Math.round((currX - X_Side) / Tile_Size) + '0');
+            char row = (char) (Math.round((currY - Y_Side) / Tile_Size) + 'A');
+            String orientation = isFlipped ? String.valueOf(rotation + 4) : String.valueOf(rotation);
+            String piecePlacement = name + String.valueOf(row) + String.valueOf(col) + orientation;
+            if (name.charAt(0) == 'S') {
+                if (sTileTotal >= 3) {
+                    Alert alert = new Alert(Alert.AlertType.WARNING,
+                            "You have used 3 special tiles in this game!");
+                    alert.showAndWait();
+                    return false;
+                }
+                if (sTilePerTurn == 1) {
+                    Alert alert = new Alert(Alert.AlertType.WARNING,
+                            "You can only use 1 special tile each turn!");
+                    alert.showAndWait();
+                    return false;
+                }
+            }
+            if (isValidPlacementSequence(boardString + piecePlacement)) {
+                boardString += piecePlacement;
+                return true;
+            } else {
+                return false;
+            }
+        }
     }
 
     /**
-     * Create a basic text field for input and a refresh button.
+     * This method is to check whether exists valid moves
+     *
+     * @param sIncluded including special tiles or not
+     * @return boolean
      */
-    private void makeControls() {
-        Label label1 = new Label("Placement:");
-        textField = new TextField();
-        textField.setPrefWidth(300);
-        Button button = new Button("Refresh");
-        button.setOnAction(e -> {
-            makePlacement(textField.getText());
+    private boolean hasValidPlacement(boolean sIncluded) {
+        HashSet<String> availableGrids = getAvailableGrids(boardString);
+        Set<String> tiles = new HashSet<>();
+        for (int i = 0; i + 2 <= dices.length(); i += 2) {
+            tiles.add(dices.substring(i, i + 2));
+        }
+
+        if (sIncluded && sTileTotal < 3 && sTilePerTurn == 0) {
+            for (DraggablePiece sTileDraggable : sTilesNotPlaced) {
+                tiles.add(sTileDraggable.name);
+            }
+        }
+
+        for (String tile : tiles) {
+            List<Character> orientations = getOrientations(tile);
+            for (String grid : availableGrids) {
+                for (char o : orientations) {
+                    String placement = tile + grid + String.valueOf(o);
+                    if (isValidPlacementSequence(boardString + placement)) {
+                        return true;
+                    }
+                }
+            }
+        }
+        return false;
+    }
+
+
+    /**
+     * This method is used to control DraggablePiece
+     * - Scroll on the tile: rotates 90 degrees clockwise each time
+     * - Double click: flip the tile (if not flipped)
+     * - Triple click: flip back (if flipped)
+     * - Drag and release the tile on the board to place it
+     */
+    private void handlePiece(Group group) {
+        BooleanProperty isDragging = new ReadOnlyBooleanWrapper(false);
+
+        for (Node node : generatingPieces.getChildren()) {
+            DraggablePiece piece = (DraggablePiece) node;
+
+            piece.setOnScroll(e -> {    // scroll to change orientation
+                if (!isDragging.getValue() && Math.abs(e.getDeltaY()) > 30) {
+                    piece.rotate(); // cannot rotate when dragging
+                }
+                e.consume();
+            });
+
+            piece.setOnMouseClicked(e -> {  // double or triple click to flip
+                switch (e.getClickCount()) {
+                    case 2:
+                        piece.flipped();
+                        break;
+                    case 3:
+                        piece.flippedBack();
+                        break;
+                }
+            });
+
+            piece.setOnMousePressed(e -> {
+                piece.mouseX = e.getSceneX();
+                piece.mouseY = e.getSceneY();
+            });
+
+            piece.setOnMouseDragged(e -> {
+                isDragging.setValue(true);
+                piece.toFront();
+                double moveX = e.getSceneX() - piece.mouseX;
+                double moveY = e.getSceneY() - piece.mouseY;
+                piece.drag(moveX, moveY);
+                piece.mouseX = e.getSceneX();
+                piece.mouseY = e.getSceneY();
+            });
+
+            piece.setOnMouseReleased(e -> {
+                isDragging.setValue(false);
+                if (!piece.isOnBoard()) {
+                    piece.snapToHome();
+                } else if (piece.isValid()) {
+                    piece.snapToGrid();
+                    piece.setPosition();
+                    generatingPieces.getChildren().remove(piece);
+                } else {
+                    piece.snapToHome();
+                }
+
+                // In the last turn, check valid moves and show the information if necessary
+                if (diceRollTimes == 7) {
+                    if (!hasValidPlacement(true)) {
+                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
+                                "No more moves, press OK to get the score", ButtonType.OK);
+                        alert.showAndWait();
+                        if (group == rootSingle) {
+                            int score = getAdvancedScore(boardString);
+                            resultInfo = new Text(VIEWER_WIDTH / 2, 60,
+                                    "Total Score: " + score);
+                            resultInfo.setFont(Font.font("Verdana", 20));
+                            generatingPieces.getChildren().clear();
+                            group.getChildren().add(resultInfo);
+                        } else {
+                            if (sTilesAI.size() == 3) {
+                                sTilesAI.clear();   // can only use at most 3 special tiles
+                            }
+                            boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
+                            makePlacement(boardStringAI, true, pieces);
+                            calculateScore(group);
+                        }
+                    } else if (!hasValidPlacement(false)
+                            && hasValidPlacement(true)) {
+                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
+                                "You can still place a special tile, do you want to end the game?",
+                                    ButtonType.YES, ButtonType.NO);
+                        alert.showAndWait();
+                        if (alert.getResult() == ButtonType.YES) {
+                            if (group == rootSingle) {
+                                int score = getAdvancedScore(boardString);
+                                resultInfo = new Text(VIEWER_WIDTH / 2, (double) Y_Side / 2,
+                                        "Advanced Score: " + score);
+                                resultInfo.setFont(Font.font("Verdana", 20));
+                                generatingPieces.getChildren().clear();
+                                group.getChildren().add(resultInfo);
+                            } else {
+                                if (sTilesAI.size() == 3) {
+                                    sTilesAI.clear();
+                                }
+                                boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
+                                makePlacement(boardStringAI, true, pieces);
+                                calculateScore(group);
+                            }
+                        }
+                    }
+                }
+            });
+
+        }
+    }
+
+    /* Get the total result for Player to AI mode */
+    private void calculateScore(Group group) {
+        int scorePlayer = getAdvancedScore(boardString);
+        int scoreAI = getAdvancedScore(boardStringAI);
+        int errorPlayer = -countErrorsScore(boardString);
+        int errorAI = -countErrorsScore(boardStringAI);
+
+        String winnerInfo = "Winner: ";
+        if (scoreAI == scorePlayer) {
+            if (errorPlayer < errorAI) {
+                winnerInfo += "Player!";
+            } else if (errorAI < errorPlayer) {
+                winnerInfo += "AI!";
+            } else {
+                winnerInfo = "Tie!";
+            }
+        } else if (scoreAI < scorePlayer) {
+            winnerInfo += "Player!";
+        } else {
+            winnerInfo += "AI!";
+        }
+
+        resultInfo = new Text(X_Side + 2 * Tile_Size, Y_Side / 3f, winnerInfo);
+        resultInfo.setFont(Font.font("Verdana", 30));
+        Label scoreP, scoreA;
+        if (!winnerInfo.equals("Tie")) {
+            scoreP = new Label("Player's Score: " + scorePlayer);
+            scoreA = new Label("AI's Score: " + scoreAI);
+        } else {
+            scoreP = new Label("Player's Score: " + scorePlayer + " Errors: " + errorPlayer);
+            scoreA = new Label("AI's Score: " + scoreAI + " Errors: " + errorAI);
+        }
+        VBox scores = new VBox(scoreP, scoreA);
+        scores.setSpacing(10);
+        scores.setLayoutX(X_Side + 5 * Tile_Size);
+        scores.setLayoutY(Y_Side / 3f);
+        group.getChildren().addAll(scores, resultInfo);
+        generatingPieces.getChildren().clear();
+    }
+
+
+    /* This method can clear current game state for any modes */
+    private void clearAll() {
+        if (textField != null) {
             textField.clear();
+        }
+        initSTiles();
+        generatingPieces.getChildren().clear();
+        placedPieces.getChildren().clear();
+        aiPieces.getChildren().clear();
+        sTilesNotPlaced.clear();
+        diceRollTimes = sTilePerTurn = sTileTotal = 0;
+        dices = dicesAI = boardString = boardStringAI = "";
+        resultInfo = resultInfoAI = null;
+        pieces.getChildren().clear();
+
+        rootPlayer.getChildren().clear();
+        rootPlayer.getChildren().addAll(boardBGImg, boardPlayer, generatingPieces, placedPieces);
+
+        rootAI.getChildren().clear();
+        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAI, pieces);
+
+        rootAIComponent.getChildren().clear();
+        rootAIComponent.getChildren().addAll(aiComponentImg, boardAIComponent, controlsAiComponent, aiPieces);
+
+        rootSingle.getChildren().clear();
+
+        //Bob modified
+        rootSingle.getChildren().addAll(boardBGImg, boardSingleMode, controls, generatingPieces, placedPieces, pieces);
+    }
+
+
+    /**
+     * This method controls the main scene where users can switch to different modes
+     * modes:
+     * - Single mode ("Single game")
+     * - Player to AI mode ("Play with computer")
+     * - Debug mode ("Debug mode")
+     * - AI to AI mode ("AI to AI")
+     *
+     * @param primaryStage the main stage of the program
+     */
+    private void mainSceneSetting(Stage primaryStage) {
+        initSTiles();
+        primaryStage.setScene(sceneMain);
+
+        sceneMain.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm()); // Bob modified
+
+        sceneMain.setOnKeyPressed(e -> {
+            if (e.getCode() == KeyCode.Q) {
+                primaryStage.close();
+            }
+        });
+
+        VBox vBox = new VBox();
+        vBox.setAlignment(Pos.CENTER_LEFT);
+        vBox.setLayoutX(VIEWER_WIDTH / 2 - Tile_Size);
+        vBox.setLayoutY(VIEWER_HEIGHT / 2 - Tile_Size);
+        vBox.setSpacing(30);
+        Text title = new Text(VIEWER_WIDTH / 3, X_Side, "Railroad Ink");
+        title.setFont(Font.font("Verdana", 50));
+
+        Button single = new Button("Single game");
+        single.setOnAction(e -> {
+            singleOrDebug(primaryStage, true);
+
+        });
+
+        Button debug = new Button("Debug mode");
+        debug.setOnAction(e -> {
+            singleOrDebug(primaryStage, false);
+        });
+
+        Button computerMode = new Button("Play with computer");
+        computerMode.setOnAction(e -> {
+            playWithAI(primaryStage);
+        });
+
+        Button aiComponentMode = new Button("AI to AI");
+        aiComponentMode.setOnAction(e -> {
+            aiToAiMode(primaryStage);
+        });
+        // Bob modified
+        bgMusic.setCycleCount(Viewer.MUSIC_MODE);
+        bgMusic.play(); // play music
+
+        mainBgImg = new ImageView();
+        mainBgImg.setImage(new Image(getClass().getResource(URI_BASE + "bg.jpg").toString()));
+        mainBgImg.setFitWidth(VIEWER_WIDTH);
+        mainBgImg.setFitHeight(VIEWER_HEIGHT);
+        mainBgImg.setOpacity(0.8);
+
+        boardBGImg = new ImageView();
+        boardBGImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
+        boardBGImg.setFitWidth(VIEWER_WIDTH);
+        boardBGImg.setFitHeight(VIEWER_HEIGHT);
+        boardBGImg.setOpacity(0.45);
+
+        aiGroupImg = new ImageView();
+        aiGroupImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
+        aiGroupImg.setFitWidth(VIEWER_WIDTH);
+        aiGroupImg.setFitHeight(VIEWER_HEIGHT);
+        aiGroupImg.setOpacity(0.45);
+
+        aiComponentImg = new ImageView();
+        aiComponentImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
+        aiComponentImg.setFitWidth(VIEWER_WIDTH);
+        aiComponentImg.setFitHeight(VIEWER_HEIGHT);
+        aiComponentImg.setOpacity(0.45);
+
+        vBox.getChildren().addAll(single, computerMode, debug, aiComponentMode);
+        // Bob modified
+        mainGroup.getChildren().addAll(mainBgImg, vBox, title);
+    }
+
+    /* Method for drawing board */
+    private void drawBoard(Group group) {
+        for (int i = 0; i < 8; i++) {
+            Line row = new Line();
+            Line column = new Line();
+            row.setStartX(X_Side);
+            row.setStartY(Y_Side + i * Tile_Size);
+            row.setEndX(X_Side + 7 * Tile_Size);
+            row.setEndY(Y_Side + i * Tile_Size);
+            column.setStartX(X_Side + i * Tile_Size);
+            column.setStartY(Y_Side);
+            column.setEndX(X_Side + i * Tile_Size);
+            column.setEndY(Y_Side + 7 * Tile_Size);
+            group.getChildren().addAll(row, column);
+            if (i == 2 || i == 5) {
+                Line redRow = new Line();
+                Line redCol = new Line();
+                redRow.setStartX(X_Side + 2 * Tile_Size);
+                redRow.setStartY(Y_Side + i * Tile_Size);
+                redRow.setEndX(X_Side + 5 * Tile_Size);
+                redRow.setEndY(Y_Side + i * Tile_Size);
+                redCol.setStartX(X_Side + i * Tile_Size);
+                redCol.setStartY(Y_Side + 2 * Tile_Size);
+                redCol.setEndX(X_Side + i * Tile_Size);
+                redCol.setEndY(Y_Side + 5 * Tile_Size);
+                redRow.setStroke(Color.RED);
+                redCol.setStroke(Color.RED);
+                group.getChildren().addAll(redRow, redCol);
+            }
+
+        }
+    }
+
+
+    /**
+     * Making and handle controls for all scenes except the main scene.
+     *
+     * @param group      the control Group
+     * @param isGameMode gameMode is singleOrDebug or Player to AI mode
+     * @param stage      primaryStage
+     */
+    private void makeControls(Group group, boolean isGameMode, Stage stage) {
+        Button diceRoll = new Button("Roll a dice");
+        Button clear = new Button("Clear");
+        Button changeView = new Button("Change to AI");
+        Button changeAi = new Button("Change AI");
+        Button changeAiBack = new Button("Change to another AI");
+        Button newGame = new Button("New Game");
+        Button newGameAi = new Button("New Game");
+        Button switchBack = new Button("Go back to player");
+        Button newMove = new Button("New Turn");
+
+        diceRoll.setOnAction(e -> {
+            if (diceRollTimes >= 7) {
+                if (group == rootSingle && !generatingPieces.getChildren().isEmpty()) {
+                    int score = getAdvancedScore(boardString);
+                    resultInfo = new Text(VIEWER_WIDTH / 2, 60, "Total Score: " + score);
+                    resultInfo.setFont(Font.font("Verdana", 20));
+                    group.getChildren().add(resultInfo);
+                    generatingPieces.getChildren().clear();
+                } else {
+                    Alert alert = new Alert(Alert.AlertType.WARNING, "7 rounds reached");
+                    alert.showAndWait();
+                }
+            } else {
+                if (group == rootPlayer && !dicesAI.isEmpty()) {
+                    Alert alert = new Alert(Alert.AlertType.WARNING,
+                            "You must press 'Change to AI' before the next turn!");
+                    alert.showAndWait();
+                } else {
+                    generateDicePieces(group);
+                }
+            }
+
+        });
+
+        clear.setOnAction(e -> {
+            clearAll();
+        });
+
+        // play move of AI and change board to AI (Player to AI mode)
+        changeView.setOnAction(e -> {
+            if (!dices.isEmpty() && hasValidPlacement(false)) {
+                Alert alert = new Alert(Alert.AlertType.WARNING,
+                        "You must place regular tiles as many as you can!");
+                alert.showAndWait();
+            } else {
+                stage.setScene(sceneAI);
+                if (!dicesAI.isEmpty()) {
+                    if (sTilesAI.size() == 3) {
+                        sTilesAI.clear();
+                    }
+                    boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
+                    makePlacement(boardStringAI, true, pieces);
+                    if (diceRollTimes == 7) {
+                        calculateScore(rootPlayer);
+                    }
+                }
+            }
+        });
+
+        newGame.setOnAction(e -> {
+            clearAll();
+            playWithAI(stage);
+        });
+
+        newGameAi.setOnAction(e -> {
+            clearAll();
+            aiToAiMode(stage);
+        });
+
+        switchBack.setOnAction(e -> {
+            stage.setScene(scenePlayer);
+        });
+
+        changeAi.setOnAction(e -> {
+            stage.setScene(sceneAIComponent);
+        });
+
+        changeAiBack.setOnAction(e -> {
+            stage.setScene(sceneAI);
+        });
+
+        newMove.setOnAction(e -> {
+            playMoveAi();
+        });
+
+        HBox buttonBox = new HBox();
+        buttonBox.setLayoutX(40);
+        buttonBox.setLayoutY(40);
+        buttonBox.setSpacing(13);
+
+        // Player to AI mode
+        if (group == rootPlayer) {
+            buttonBox.getChildren().addAll(diceRoll, changeView, newGame);
+            controlsPlayer.getChildren().add(buttonBox);
+            switchBack.setLayoutX(40);
+            switchBack.setLayoutY(40);
+            controlsAI.getChildren().add(switchBack);
+        }
+
+        // AI to AI mode
+        if (group == rootAI) {
+            buttonBox.getChildren().addAll(newMove, changeAi, newGameAi);
+            changeAiBack.setLayoutX(40);
+            changeAiBack.setLayoutY(40);
+            controlsAIMode.getChildren().add(buttonBox);
+            controlsAiComponent.getChildren().add(changeAiBack);
+        }
+
+        // Debug or Single mode
+        if (group == rootSingle) {
+            buttonBox.getChildren().addAll(diceRoll, clear);
+
+            HBox hb = new HBox();   // HBox collections for debug mode
+            Label label1 = new Label("Placement:");
+            textField = new TextField();
+            textField.setPrefWidth(300);
+            Button button = new Button("Refresh");
+            Button placeTiles = new Button("Place tiles");
+            button.setOnAction(e -> {
+                makePlacement(textField.getText(), false, pieces);
+                textField.clear();
+            });
+            placeTiles.setOnAction(e -> {
+                makePlacement(textField.getText(), false, pieces);
+            });
+            hb.getChildren().addAll(label1, textField, button, placeTiles);
+            hb.setSpacing(20);
+            hb.setLayoutX(130);
+            hb.setLayoutY(VIEWER_HEIGHT - 50);
+
+            if (isGameMode) {       // single game mode
+                controls.getChildren().clear();
+                controls.getChildren().add(buttonBox);
+            } else {                // debug mode
+                controls.getChildren().clear();
+                controls.getChildren().add(hb);
+            }
+        }
+    }
+
+    /* Init the special tiles collections (AI to AI mode) */
+    private void initSTiles() {
+        sTilesAI.clear();
+        sTileAIComponent.clear();
+        for (int i = 0; i < 6; i++) {
+            sTilesAI.add("S" + i);
+            sTileAIComponent.add("S" + i);
+        }
+    }
+
+
+    /* This method is for ai to ai mode */
+    private void playMoveAi() {
+        diceRollTimes++;
+        if (diceRollTimes > 1 && diceRollTimes < 8) {       // prevent adding the same node twice
+            rootAI.getChildren().remove(turnInfo);
+            rootAIComponent.getChildren().remove(turnInfoAI);
+        }
+
+        if (diceRollTimes < 8) {
+            dices = dicesAI = generateDiceRoll();
+            if (sTilesAI.size() == 3) {
+                sTilesAI.clear();
+            }
+            if (sTileAIComponent.size() == 3) {
+                sTileAIComponent.clear();
+            }
+            boardString += generateMove(boardString, dices);    // AI 1
+            boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTileAIComponent); // AI 2
+            makePlacement(boardString, false, pieces);
+            makePlacement(boardStringAI, false, aiPieces);
+
+            // update the turn information
+            turnInfo = new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes);
+            turnInfoAI = new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes);
+            turnInfo.setFont(Font.font("Verdana", 20));
+            turnInfoAI.setFont(Font.font("Verdana", 20));
+            rootAI.getChildren().add(turnInfo);
+            rootAIComponent.getChildren().add(turnInfoAI);
+        }
+
+        if (diceRollTimes >= 7) {   // end the game and displays the result
+            if (resultInfo == null && resultInfoAI == null) {
+                int score1 = getAdvancedScore(boardString);
+                int score2 = getAdvancedScore(boardStringAI);
+                resultInfo = new Text(X_Side + 4 * Tile_Size, Y_Side / 2f,
+                        "AI1 score: " + score1 + "  " + "AI2 score: " + score2);
+                resultInfo.setFont(Font.font("Verdana", 27));
+                resultInfoAI = new Text(X_Side + 4 * Tile_Size, Y_Side / 2f,
+                        "AI1 score: " + score1 + "  " + "AI2 score: " + score2);
+                resultInfoAI.setFont(Font.font("Verdana", 27));
+                rootAI.getChildren().add(resultInfo);
+                rootAIComponent.getChildren().add(resultInfoAI);
+            }
+        }
+    }
+
+    /* Init method for the Player to AI Mode */
+    private void playWithAI(Stage stage) {
+        stage.setScene(scenePlayer);
+
+        scenePlayer.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm());   // Bob
+        sceneAI.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm());   // Bob
+
+        scenePlayer.setOnKeyPressed(e -> {
+            if (e.getCode() == KeyCode.ESCAPE) {
+                clearAll();
+                stage.setScene(sceneMain);
+            }
+        });
+
+        sceneAI.setOnKeyPressed(e -> {
+            if (e.getCode() == KeyCode.ESCAPE) {
+                clearAll();
+                stage.setScene(sceneMain);
+            }
+        });
+
+        makeControls(rootPlayer, true, stage);
+        rootPlayer.getChildren().clear();
+        rootPlayer.getChildren().addAll(boardBGImg, boardPlayer, controlsPlayer, generatingPieces, placedPieces);
+
+        rootAI.getChildren().clear();
+        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAI, pieces);
+    }
+
+    /**
+     * Init method for the Single and Debug mode.
+     * @param stage the main stage of the game
+     * @param isGameMode if true, it is singleOrDebug, otherwise debug mode
+     */
+    private void singleOrDebug(Stage stage, boolean isGameMode) {
+        stage.setScene(sceneSingle);
+
+
+        sceneSingle.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm()); // Bob modified
+
+        sceneSingle.setOnKeyPressed(e -> {
+           if (e.getCode() == KeyCode.ESCAPE) {
+                clearAll();
+                stage.setScene(sceneMain);
+            }
         });
-        HBox hb = new HBox();
-        hb.getChildren().addAll(label1, textField, button);
-        hb.setSpacing(10);
-        hb.setLayoutX(130);
-        hb.setLayoutY(VIEWER_HEIGHT - 50);
-        controls.getChildren().add(hb);
+
+        makeControls(rootSingle, isGameMode, stage);
+        rootSingle.getChildren().clear();
+        rootSingle.getChildren().addAll(boardBGImg, boardSingleMode, controls, pieces, generatingPieces, placedPieces);
     }
 
+    /* Init method for AI to AI mode */
+    private void aiToAiMode(Stage stage) {
+        stage.setScene(sceneAI);
+
+        sceneAI.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm());
+        sceneAIComponent.getStylesheets().add(this.getClass().getResource(
+                "GameBoardBG.css").toExternalForm());
+
+        sceneAI.setOnKeyPressed(e -> {
+            if (e.getCode() == KeyCode.ESCAPE) {
+                clearAll();
+                stage.setScene(sceneMain);
+            }
+        });
+
+        sceneAIComponent.setOnKeyPressed(e -> {
+            if (e.getCode() == KeyCode.ESCAPE) {
+                clearAll();
+                stage.setScene(sceneMain);
+            }
+        });
+        makeControls(rootAI, false, stage);
+        rootAI.getChildren().clear();
+        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAIMode, pieces);
+
+        rootAIComponent.getChildren().clear();
+        rootAIComponent.getChildren().addAll(aiComponentImg, boardAIComponent, controlsAiComponent, aiPieces);
+
+    }
+
+
     @Override
     public void start(Stage primaryStage) throws Exception {
-        primaryStage.setTitle("StepsGame Viewer");
-        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
+        primaryStage.setTitle("Railroad Ink V1.0");
+        primaryStage.getIcons().add(new Image(getClass().getResource(URI_BASE + "icon.png").toString()));
+        drawBoard(boardSingleMode);
+        drawExits(boardSingleMode);
+
+        drawBoard(boardPlayer);
+        drawExits(boardPlayer);
 
-        root.getChildren().add(controls);
+        drawBoard(boardAI);
+        drawExits(boardAI);
 
-        makeControls();
+        drawBoard(boardAIComponent);
+        drawExits(boardAIComponent);
 
-        primaryStage.setScene(scene);
+        mainSceneSetting(primaryStage);
         primaryStage.show();
     }
+
+
+    public static void main(String[] args) {
+        launch(args);
+    }
 }
Only in comp1110-ass2/src/comp1110/ass2: RailroadInk.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java comp1110-ass2/src/comp1110/ass2/RailroadInk.java
--- ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 13:59:04.556397359 +1000
+++ comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 14:01:20.037208834 +1000
@@ -1,5 +1,7 @@
 package comp1110.ass2;
 
+import java.util.*;
+
 public class RailroadInk {
     /**
      * Determine whether a tile placement string is well-formed:
@@ -9,13 +11,25 @@
      * - the third character represents the placement row A-G
      * - the fourth character represents the placement column 0-6
      * - the fifth character represents the orientation 0-7
-     *
+     * @author Frederick Li
      * @param tilePlacementString a candidate tile placement string
      * @return true if the tile placement is well formed
      */
     public static boolean isTilePlacementWellFormed(String tilePlacementString) {
         // FIXME Task 2: determine whether a tile placement is well-formed
-        return false;
+        if (tilePlacementString.length() != 5) {return false;}
+        if (!"ABS".contains(""+tilePlacementString.charAt(0))) {return false;}
+        if (tilePlacementString.charAt(0) == 'B') {
+            if (tilePlacementString.charAt(1) < '0' || tilePlacementString.charAt(1) > '2') {return false;}
+        }
+        else {
+            if (tilePlacementString.charAt(1) < '0' || tilePlacementString.charAt(1) > '5') {return false;}
+        }
+        if (tilePlacementString.charAt(2) < 'A' || tilePlacementString.charAt(2) > 'G') {return false;}
+        if (tilePlacementString.charAt(3) < '0' || tilePlacementString.charAt(3) > '6') {return false;}
+        if (tilePlacementString.charAt(4) < '0' || tilePlacementString.charAt(4) > '7') {return false;}
+
+        return true;
     }
 
     /**
@@ -23,13 +37,68 @@
      * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
      * - each piece placement is well-formed
      * - no more than three special tiles are included
-     *
+     * @author Frederick Li
      * @param boardString a board string describing the placement of one or more pieces
      * @return true if the board string is well-formed
      */
     public static boolean isBoardStringWellFormed(String boardString) {
         // FIXME Task 3: determine whether a board string is well-formed
-        return false;
+        if (boardString == null || boardString.length() == 0) {return false;}
+        if (boardString.length() % 5 != 0 || boardString.length() > 155) {return false;}
+        int count = 0;
+        for (int i = 0; i + 5 <= boardString.length(); i = i + 5) {
+            String tilePlacement = boardString.substring(i, i+5);
+            if (!isTilePlacementWellFormed(tilePlacement)) {return false;}
+            if (boardString.charAt(i) == 'S') {count++;}
+            if (count > 3) {return false;}
+        }
+        List<String> positions = new ArrayList<>();
+        for (int i = boardString.length()-5; i >= 0; i -= 5) {
+            String position = boardString.substring(i+2, i+4);
+            if (positions.contains(position)) {
+                return false;
+            } else {
+                positions.add(position);
+            }
+        }
+        return true;
+    }
+
+
+    /**
+     * This method is to get the shape of the tile. Shape is a string contains 4 characters.
+     * h: represents highway edge
+     * r: represents railway edge
+     * #: represents blank edge
+     * The order of the string is up, left, bottom, right
+     * @author Frederick Li, Haoyan Liu
+     * @param tilePlacement a char array of tile placement which contains 5 elements."B0A53"
+     * @param orientation a char which is in the range '0'-'7'
+     * @return a string which represents the shape of the tile
+     */
+    static String getShape(char[] tilePlacement, char orientation) {
+        String[] shapeA = {"rr##", "r#r#", "r#rr", "h#hh", "h#h#", "hh##"}; // shapes of A with orientation '0'
+        String[] shapeB = {"h#r#", "h##r", "hrhr"};//shape of B with orientation 0
+        String[] shapeS = {"hhrh", "hrrr", "hhhh", "rrrr", "hhrr", "hrhr"};//shape of S with orientation 0
+        char[] shape;
+        if (tilePlacement[0] == 'A') {
+            shape = shapeA[tilePlacement[1] - '0'].toCharArray();// shape char output
+        }
+        else if (tilePlacement[0] == 'B') {
+            shape = shapeB[tilePlacement[1] - '0'].toCharArray();
+        }
+        else {
+            shape = shapeS[tilePlacement[1] - '0'].toCharArray();
+        }
+
+        if (orientation > '3') {
+            char temp = shape[3];
+            shape[3] = shape[1];
+            shape[1] = temp;//exchange ( see the shape)
+        }
+        String flipped = String.valueOf(shape);
+        int offset = orientation > '3' ?(int) orientation  - '0' - 4 : (int) orientation - '0';
+        return flipped.substring(offset) + flipped.substring(0, offset);
     }
 
 
@@ -41,14 +110,194 @@
      * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
      * invalid connection between highway and railway; and
      * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
-     *
+     * @author Frederick Li, Haoyan Liu
      * @return true if the placements are connected neighbours
      */
+
     public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
         // FIXME Task 5: determine whether neighbouring placements are connected
+        if (tilePlacementStringA.length() < 5 || tilePlacementStringB.length() < 5) {return false;}
+        char[] a = tilePlacementStringA.toCharArray();
+        char[] b = tilePlacementStringB.toCharArray();
+        if (Math.abs(a[2] - b[2]) > 1 || Math.abs(a[3] - b[3]) > 1) {return false;} //not adjacent
+        if (a[2] == b[2] && a[3] == b[3]) {return false;}
+        if (Math.abs(a[2] - b[2]) == 1 && Math.abs(a[3] - b[3]) == 1) {return false;} //diagonal position
+        char[] aShape = getShape(a, a[4]).toCharArray();
+        char[] bShape = getShape(b, b[4]).toCharArray();
+
+        if (a[2] > b[2]) {
+            if (!(aShape[0] == bShape[2] && aShape[0] != '#')) {return false;}  //vertically adjacent
+        }
+        if (a[2] < b[2]) {
+            if (!(aShape[2] == bShape[0] && aShape[2] != '#')) {return false;} //vertically adjacent
+        }
+        if (a[3] > b[3]) {
+            if (!(aShape[1] == bShape[3] && aShape[1] != '#')) {return false;} //horizontally adjacent
+        }
+        if (a[3] < b[3]) {
+            if (!(aShape[3] == bShape[1] && aShape[3] != '#')) {return false;} //horizontally adjacent
+        }
+        return true;
+    }
+
+
+    /**
+     * This method is to check whether a tile is legally connected to an exit
+     * @author Frederick Li
+     * @param tilePlacement a string of 5 characters
+     * @return boolean
+     */
+    static boolean isExitConnected(String tilePlacement) {
+        char[] a = tilePlacement.toCharArray();
+        char[] aShape = getShape(a, a[4]).toCharArray();
+
+        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) {// possible exits
+            if ((a[3] == '1' || a[3] =='5') && aShape[a[2] == 'A' ? 0 : 2] == 'h') // if fst or last column matches highway
+            {return true;}
+            else
+            {return (a[3] == '3' && aShape[a[2] == 'A' ? 0 : 2] == 'r');} //matches railway
+        }
+        else
+        if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) { // else possible exit
+            if ((a[2] == 'B' || a[2] == 'F') && aShape[a[3] == '0' ? 1 : 3] == 'r') // last row<-> down is exit position
+            {return true;}
+            else
+            {return (a[2] == 'D' && aShape[a[3] == '0' ? 1 : 3] == 'h');}
+        }
+
         return false;
     }
 
+
+    /**
+     * This method is to check whether a tile near the exit has valid connection to the exit.
+     * @author Frederick Li
+     * @param tilePlacement a string contains 5 characters
+     * @return boolean
+     */
+    private static boolean isInvalidExitConnection(String tilePlacement) {
+        char[] a = tilePlacement.toCharArray();
+        char[] aShape = getShape(a, a[4]).toCharArray();
+
+        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) { // possible exits
+            if (aShape[a[2] == 'A' ? 0 : 2] != '#') {  // if tile at the fst row , up is not be vacant / If last, down
+                //is not be vacant.
+                return (!isExitConnected(tilePlacement));
+            }
+
+        }
+        else if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) {
+            if (aShape[a[3] == '0' ? 1 : 3] != '#') {
+                return (!isExitConnected(tilePlacement));
+            }
+        }
+        return false;
+    }
+
+
+    /**
+     * This method is to get the adjacent grids of a tile if it exits
+     * @author Frederick Li
+     * @param tilePlacement a tile
+     * @return a List of adjacent grids positions
+     */
+    private static List<String> getAdjGrids(String tilePlacement) {
+        List<String> adjGrids = new ArrayList<>();
+        if (tilePlacement.isEmpty()) {
+            return adjGrids;
+        }
+        char row = tilePlacement.charAt(2);
+        char col = tilePlacement.charAt(3);
+        char[] adjRow = {(char) (row-1), row, (char) (row+1)};
+        char[] adjCol = {(char) (col-1), col, (char) (col+1)};
+        for (char r: adjRow) {
+            for (char c: adjCol) {
+                if (r < 'A' || r > 'G' || c < '0' || c > '6') {
+                    continue;
+                }
+                if (Math.abs(r - row) == 1 && Math.abs(c - col) == 1) {
+                    continue;
+                }
+                if (r == row && c == col) {
+                    continue;
+                }
+                String adjGrid = String.valueOf(r) + String.valueOf(c);
+                if (!adjGrids.contains(adjGrid)) {
+                    adjGrids.add(adjGrid);
+                }
+            }
+        }
+        return adjGrids;
+    }
+
+
+    /**
+     * A method split a board string into an array of  tile placements
+     * @author Frederick Li
+     * @param string a string needs to be split
+     * @param len the length of substring
+     * @return an array of tile placements
+     */
+    public static String[] splitString(String string, int len) {
+        String[] subStrings = new String[string.length()/len];
+        for (int i = 0; i+len <= string.length(); i += len) {
+            subStrings[i/len] = string.substring(i, i+len);
+        }
+        return subStrings;
+    }
+
+
+    /**
+     * A helper method for isValidPlacementSequence that is to check
+     *      whether all neighbouring tiles are validly connected for a new placement string
+     * @author Frederick Li
+     * @param boardString the original game state
+     * @param newPlacementString a sequence of new placements
+     * @return boolean
+     */
+    public static boolean areNeighboursValid(String boardString, String newPlacementString) {
+        HashMap<String, String> placed = new HashMap<>();
+        for (int i = 0; i+5 <= boardString.length(); i+=5) {
+            String grid = boardString.substring(i+2, i+4);
+            placed.put(grid, boardString.substring(i, i + 5));
+        }
+
+        String[] newPlacements = splitString(newPlacementString, 5);
+
+        for (String placement : newPlacements) {
+            List<String> adjGrids = getAdjGrids(placement);
+            char row = placement.charAt(2);
+            char col = placement.charAt(3);
+            for (String grid: adjGrids) {
+                char r = grid.charAt(0);
+                char c = grid.charAt(1);
+
+                if (placed.containsKey(grid)) { // placed tiles are in its adjacent grids
+                    String neighbour = placed.get(grid);
+                    String placementShape = getShape(placement.toCharArray(), placement.charAt(4));
+                    String neighbourShape = getShape(neighbour.toCharArray(), neighbour.charAt(4));
+                    if (row == r && (col < c
+                            ? (placementShape.charAt(3) != '#' && neighbourShape.charAt(1) != '#' &&
+                            placementShape.charAt(3) != neighbourShape.charAt(1))
+                            : (placementShape.charAt(1) != '#' && neighbourShape.charAt(3) != '#' &&
+                            placementShape.charAt(1) != neighbourShape.charAt(3)))) {
+                        return false;
+                    }
+                    if (col == c && (row < r
+                            ? (placementShape.charAt(2) != '#' && neighbourShape.charAt(0) != '#' &&
+                            placementShape.charAt(2) != neighbourShape.charAt(0))
+                            : (placementShape.charAt(0) != '#' && neighbourShape.charAt(2) != '#' &&
+                            placementShape.charAt(0) != neighbourShape.charAt(2)))) {
+                        return false;
+                    }
+                }
+            }
+            placed.put(placement.substring(2, 4), placement);
+        }
+        return true;
+    }
+
+
     /**
      * Given a well-formed board string representing an ordered list of placements,
      * determine whether the board string is valid.
@@ -61,15 +310,42 @@
      *   Highways and railways may only join at station tiles.
      * - A tile may have one or more edges touching a blank edge of another tile;
      *   this is referred to as disconnected, but the placement is still legal.
-     *
+     * @author Frederick Li
      * @param boardString a board string representing some placement sequence
      * @return true if placement sequence is valid
      */
     public static boolean isValidPlacementSequence(String boardString) {
         // FIXME Task 6: determine whether the given placement sequence is valid
-        return false;
+        if (!isBoardStringWellFormed(boardString)) {
+            return false;
+        }
+        String[] tiles = new String[boardString.length() / 5];// 5 letters in a tile representation.
+        String[] placed = new String[tiles.length];
+        for (int i = 0; i+5 <= boardString.length() ; i += 5) {
+            tiles[i/5] = boardString.substring(i, i+5);// representation of  i/5 th tile
+            placed[i/5] = i == 0 ? boardString.substring(i, i+5) : "" ;
+        }
+
+        if (!(isExitConnected(tiles[0]))) {return false;}
+        for (int i = 1; i < tiles.length; i++) {
+            for (int j = 0; j < placed.length; j++ ) {
+                if (isExitConnected(tiles[i])) {
+                    placed[i] = tiles[i];
+                    continue;
+                }
+                if (areConnectedNeighbours(tiles[i], placed[j]) && !isInvalidExitConnection(tiles[i])) {
+                    placed[i] = tiles[i];
+                }
+            }
+        }
+
+        if (!areNeighboursValid("",boardString)) {
+            return false;
+        }
+        return Arrays.equals(tiles, placed);
     }
 
+
     /**
      * Generate a random dice roll as a string of eight characters.
      * Dice A should be rolled three times, dice B should be rolled once.
@@ -77,14 +353,233 @@
      * Die B has faces numbered 0-2.
      * Each die roll is composed of a character 'A' or 'B' representing the dice,
      * followed by a digit character representing the face.
-     *
+     * @author Haoyan Liu
      * @return a String representing the die roll e.g. A0A4A3B2
      */
     public static String generateDiceRoll() {
         // FIXME Task 7: generate a dice roll
-        return "";
+        Random r = new Random();
+        String [] possibleRole={"AAAB", "ABAA", "AABA", "BAAA"};
+        String diceroll = possibleRole[0];
+        String output ="";
+        int i=0;
+        while (i<4) {
+            char dice = diceroll.charAt(i);
+            output = output + diceroll.charAt(i);
+            if (dice == 'A') {
+                output +=  r.nextInt(6);
+            }
+            if (dice=='B') {
+                output+=  r.nextInt(3);
+            }
+            i=i+1;
+        }
+        return output;
+    }
+
+
+    /**
+     * Replace the B2 tile with two single tiles
+     * @author Mingchao Sima
+     * @param B2 a String of B2 tile placement
+     * @return the ArrayList of the replaced tiles
+     */
+    private static ArrayList<String> replaceB2(String B2) {
+        ArrayList<String> replace = new ArrayList<>();
+        if (getShape(B2.toCharArray(), B2.charAt(4)).charAt(0) == 'h'){ // top is highway
+            replace.add("A1" + B2.substring(2,4) + "1");// rotate A1
+            replace.add("A4" + B2.substring(2,4) + "0");// change it to A1 and A4
+        }else {
+            replace.add("A1" + B2.substring(2,4) + "0");
+            replace.add("A4" + B2.substring(2,4) + "1");// rotate A4
+        }
+        return replace;
     }
 
+
+    /**
+     * This method is to get the adjacent tiles of a tile from a list of tiles
+     * @author Mingchao Sima
+     * @param tilePlacement the target tile
+     * @param tiles an ArrayList contains all unconnected tiles
+     * @return an ArrayList of all adjacent tiles
+     */
+    private static ArrayList<String> getNeighbours(String tilePlacement, ArrayList<String> tiles) {
+        ArrayList<String> result = new ArrayList<>();
+        for(String tile: tiles) {
+            if (areConnectedNeighbours(tilePlacement, tile)) {
+                result.add(tile);
+            }
+        }
+        return result;
+    }
+
+
+    /**
+     * This method is to check whether a tile is B2 tile
+     * @author Frederick Li
+     * @param placement tile placement string
+     * @return boolean
+     */
+    private static boolean isB2Tile(String placement) {
+        return placement.charAt(0) == 'B' && placement.charAt(1) == '2';
+    }
+
+
+    /**
+     * Count the total scores of connected exits of all routes
+     * @author Frederick Li, Mingchao Sima
+     * @param boardString a string represents the game state
+     * @return the score of all routes based on their connected exits
+     */
+    public static int countExitsScore(String boardString) {
+        ArrayList<String> tiles = new ArrayList<>();
+        for (int i = 0; i+5 <= boardString.length(); i += 5) {
+            if (!isB2Tile(boardString.substring(i, i+5))) {
+                tiles.add(boardString.substring(i, i+5));
+            }
+            else{
+                tiles.addAll(replaceB2(boardString.substring(i, i+5)));
+            }
+        }
+
+        int sum = 0;  // total score
+
+        HashSet<String> connectedTiles = new HashSet<>();
+        HashSet<String> route = new HashSet<>();
+
+        while (!tiles.isEmpty()) {
+            if (route.isEmpty()) {
+                for (String tile : tiles) {
+                    if (isExitConnected(tile)) {
+                        route.add(tile);
+                        connectedTiles.add(tile);
+                        break;
+                    }
+                }
+            }
+
+            // add the first tile if route is still empty
+            if (route.isEmpty()) {
+                route.add(tiles.get(0));
+                connectedTiles.add(tiles.get(0));
+            }
+
+            for (String tileCollected : route) {
+                connectedTiles.addAll(getNeighbours(tileCollected, tiles));
+            }
+            // Update route and tiles
+            route.addAll(connectedTiles);
+            tiles.removeAll(connectedTiles);
+            connectedTiles.clear();
+
+            boolean flag = false;  // This flag determines whether this route can be expanded
+
+            outerLoop:
+            for (String t : tiles) {
+                for (String placed : route) {
+                    if (areConnectedNeighbours(t, placed)) {
+                        flag = true;
+                        break outerLoop;
+                    }
+                }
+            }
+
+            // Count exits or start a new route
+            if (!flag) {
+                int exitsCount = 0;
+                for (String t : route) {
+                    if (isExitConnected(t))
+                        exitsCount++;
+                }
+                route.clear();
+
+                if (exitsCount == 12) {sum += 45;}
+                else if (exitsCount >= 2) {sum += exitsCount * 4 - 4;}
+                exitsCount = 0;
+            }
+        }
+        return sum;
+    }
+
+
+    /**
+     * Count all errors: Errors are the edges of routes
+     *      that are not connected to an edge of the board.
+     * @author Frederick Li
+     * @param boardString a string of game state
+     * @return the number of errors also regarded as scores.
+     */
+    public static int countErrorsScore(String boardString) {
+        String[] tilePlacements = splitString(boardString, 5);
+        String[] tiles = new String[tilePlacements.length];
+        for (int i = 0; i < tiles.length; i++) {
+            tiles[i] = getShape(tilePlacements[i].toCharArray(), tilePlacements[i].charAt(4))
+                    + tilePlacements[i].substring(2, 4); // add the positions
+        }
+
+        // change tiles' shape that are connected to the blank edge of the board to #
+        for (int i = 0; i < tiles.length; i++) {
+            String t = tiles[i];
+            if (t.charAt(4) == 'A' && t.charAt(0) != '#') { //row == 'A' and shape[0] != '#'
+                t = "#" + t.substring(1);
+            }
+            if (t.charAt(4) == 'G' && t.charAt(2) != '#') {
+                t = t.substring(0, 2) + "#" +t.substring(3);
+            }
+
+            if (t.charAt(5) == '0' && t.charAt(1) != '#') {
+                t = t.charAt(0) + "#" + t.substring(2);
+            }
+
+            if (t.charAt(5) == '6' && t.charAt(3) != '#') {
+                t = t.substring(0, 3) + "#" + t.substring(4);
+            }
+            tiles[i] = t;
+        }
+
+        //  change tiles connected with neighbours to #
+        for (int i = 0; i < tiles.length; i++) {
+            for (int j = tiles.length-1; j > i; j--) {
+                if (areConnectedNeighbours(tilePlacements[i], tilePlacements[j])) {
+                    String tileI = tiles[i];
+                    String tileJ = tiles[j];
+                    if (tileI.charAt(4) == tileJ.charAt(4)) { // change the row
+                        if (tileI.charAt(5) < tileJ.charAt(5)) {
+                            tileI = tileI.substring(0, 3) + "#" + tileI.substring(4);
+                            tileJ = tileJ.charAt(0) + "#" + tileJ.substring(2);
+                        } else {
+                            tileI = tileI.charAt(0) + "#" + tileI.substring(2);
+                            tileJ = tileJ.substring(0, 3) + "#" + tileJ.substring(4);
+                        }
+                    }
+
+                    if (tileI.charAt(5) == tileJ.charAt(5)) { // change the column
+                        if (tileI.charAt(4) < tileJ.charAt(4)) {
+                            tileI = tileI.substring(0, 2) + "#" +tileI.substring(3);
+                            tileJ = "#" + tileJ.substring(1);
+                        } else {
+                            tileJ = tileJ.substring(0, 2) + "#" +tileJ.substring(3);
+                            tileI = "#" + tileI.substring(1);
+                        }
+                    }
+                    tiles[i] = tileI;
+                    tiles[j] = tileJ;
+                }
+            }
+        }
+        StringBuilder sb = new StringBuilder();
+        for (String tile : tiles) {
+            sb.append(tile.substring(0, 4));
+        }
+        int errors = 0;
+        for (char c : sb.toString().toCharArray()) {
+            if (c != '#') {errors++;} // tiles not changed to # are errors
+        }
+        return -errors;
+    }
+
+
     /**
      * Given the current state of a game board, output an integer representing the sum of all the following factors
      * that contribute to the player's final score.
@@ -92,18 +587,87 @@
      * * Number of exits mapped
      * * Number of centre tiles used
      * * Number of dead ends in the network
-     *
+     * @author Frederick Li
      * @param boardString a board string representing a completed game
      * @return integer (positive or negative) for score *not* considering longest rail/highway
      */
     public static int getBasicScore(String boardString) {
         // FIXME Task 8: compute the basic score
-        return -1;
+        String[] tilePlacements = splitString(boardString, 5);
+
+        int exitScore = 0;
+        int centerTilesScore = 0;
+        int deadEndsScore = 0;
+        exitScore = countExitsScore(boardString);
+        deadEndsScore = countErrorsScore(boardString);
+        for (String placement : tilePlacements) {
+            if (placement.charAt(2) >= 'C' && placement.charAt(2) <= 'E'
+                && placement.charAt(3) >= '2' && placement.charAt(3) <= '4') {
+                centerTilesScore++;
+            }
+        }
+        return exitScore+centerTilesScore+deadEndsScore;
+
+    }
+
+
+    /**
+     * Get all available adjacent grids.
+     * @author Frederick Li
+     * @param boardString a sequence of current game state
+     * @return a Set of String which contains all available grids
+     */
+    public static HashSet<String> getAvailableGrids(String boardString) {
+        String[] exits = {"A1", "A3", "A5", "G1", "G3", "G5", "B0", "D0", "F0", "B6", "D6", "F6"};
+        List<String> availableExits = new ArrayList<>();
+        Collections.addAll(availableExits, exits); // all exits' positions
+        List<String> placedTiles = new ArrayList<>();
+
+        for (int i = 0; i+5 <= boardString.length(); i+=5) {
+            String grid = boardString.substring(i+2, i+4);
+            availableExits.removeIf(g -> g.equals(grid));   // remove exit's grid if placed
+            placedTiles.add(boardString.substring(i, i+5)); // add all unused exit together
+        }
+        HashSet<String> availableGrids = new HashSet<>(availableExits);
+        for (String tile: placedTiles) {
+            List<String> adjGrids = getAdjGrids(tile);
+            availableGrids.addAll(adjGrids);    // add all adjacent grids
+        }
+        return availableGrids;
     }
 
+
+    /**
+     * Get all possible orientations for a specific tile after fixing orientations.
+     * @author Frederick Li
+     * @param tile a String of two chars which represent a tile
+     * @return a List of Characters which contain possible orientations
+     */
+    public static List<Character> getOrientations(String tile) {
+        List<Character> orientations = new ArrayList<>();
+        switch (tile) {
+            case "B1":
+                for (char i = '0'; i <= '7'; i++) {
+                    orientations.add(i);
+                }
+                break;
+            case "A1": case "A4": case "B2":
+                orientations.add('0');
+                orientations.add('1');
+                break;
+            default:
+                for (char i = '0'; i <= '3'; i++) {
+                    orientations.add(i);
+                }
+        }
+        return orientations;
+    }
+
+
     /**
      * Given a valid boardString and a dice roll for the round,
      * return a String representing an ordered sequence of valid piece placements for the round.
+     * @author Frederick Li
      * @param boardString a board string representing the current state of the game as at the start of the round
      * @param diceRoll a String representing a dice roll for the round
      * @return a String representing an ordered sequence of valid piece placements for the current round
@@ -111,22 +675,346 @@
      */
     public static String generateMove(String boardString, String diceRoll) {
         // FIXME Task 10: generate a valid move
-        return null;
+        String[] dices = splitString(diceRoll, 2);
+        List<String> tiles = new ArrayList<String>();
+        Collections.addAll(tiles, dices);
+
+        HashMap<String, String> usedTiles = new HashMap<>();
+        for (int i = 0; i+5 <= boardString.length() ; i+=5) {
+            usedTiles.put(boardString.substring(i+2, i+4), boardString.substring(i, i+5));
+        }
+
+        List<String> exits = Arrays.asList("A1", "A3", "A5", "G1", "G3", "G5", "B0", "D0", "F0", "B6", "D6", "F6");
+
+        String result = "";
+        int count = 0;
+        while ( count < 4) {
+            StringBuilder currBoard = new StringBuilder(boardString); // this is the current board string
+            for (int i = 0; i < tiles.size(); i++) {
+                if (currBoard.length() < boardString.length() + 5 * i) {break;}
+                String tile = tiles.get(i);
+
+                List<Character> orientations = getOrientations(tile);
+                HashSet<String> availableGrids = getAvailableGrids(currBoard.toString());
+
+                outLoop:
+                for (String grid: availableGrids) {
+                    for (char o : orientations) {
+                        String aMove = tile + grid + o;
+                        if (isExitConnected(aMove)
+                                && isValidPlacementSequence(currBoard + aMove)) {
+                            usedTiles.put(grid, aMove); // update used tiles
+                            currBoard.append(aMove);
+                            break outLoop;
+
+                        }
+                        List<String> adjGrids = getAdjGrids(tile + grid + "0");
+                        for (String usedGrid : adjGrids) {
+                            if (!usedTiles.containsKey(usedGrid)) {continue;} // no placed tiles are in its adjacent grids
+                            String placedTile = usedTiles.get(usedGrid);
+                            if (areConnectedNeighbours(aMove, placedTile)
+                                    && isValidPlacementSequence(currBoard + aMove)) {
+                                usedTiles.put(grid, aMove); // update used tiles
+                                currBoard.append(aMove);
+                                break outLoop;
+                            }
+                        }
+                    }
+                }
+            }
+
+            String move = currBoard.substring(boardString.length());
+            if (move.length() == 20) {
+                return move;  // 4 normal tiles have been used
+            } else if (result.length() < move.length()) {
+                result = move;
+            }
+
+            tiles.add(tiles.remove(0)); // shift rotate the tiles ordering
+            count++;
+
+        }
+        return result;
+    }
+
+
+    /**
+     * This method is to check whether two connected tiles have the same edge c ( r or h)
+     * @author Frederick Li
+     * @param tileA tilePlacement
+     * @param tileB tilePlacement
+     * @param c either 'r' or 'h'
+     */
+    private static boolean checkEdge(String tileA, String tileB, char c) {
+        String tileAShape = getShape(tileA.toCharArray(), tileA.charAt(4));
+        String tileBShape = getShape(tileB.toCharArray(), tileB.charAt(4));
+
+        if (tileA.charAt(2) == tileB.charAt(2)) {       // the same row
+            if (tileA.charAt(3) < tileB.charAt(3)) {
+                return tileAShape.charAt(3) == c ;
+            } else {
+                return tileAShape.charAt(1) == c;
+            }
+        } else {        // the same column
+            if (tileA.charAt(2) < tileB.charAt(2)) {
+                return tileAShape.charAt(2) == c;
+            } else {
+                return tileAShape.charAt(0) == c;
+            }
+        }
+    }
+
+
+    /**
+     * This class represents the connection of a route
+     */
+    static class TileGraph {
+        private HashMap<String, LinkedList<String>> adj; // adjacent tiles collection
+        private int vertices;
+
+         TileGraph(int vertices) {
+            this.vertices = vertices;
+            adj = new HashMap<>();
+        }
+
+        public void addTile(String key, String tile) {
+            adj.get(key).add(tile);
+        }
+
+        /**
+         * This is a recursion util function for findLongestRoad
+         * @author Frederick Li
+         * @param s a string represents the starting tile
+         * @param visited a HashMap which record the tiles that have been visited
+         * @param prev previous length
+         * @param max an array with 1 element of the length of the longest road
+         */
+        private void findLongestRoadRec(String s, HashMap<String, Boolean> visited,
+                                       int prev, int[] max) {
+            visited.put(s, true);
+            int curr = 0;
+
+            for (String adjTile : adj.get(s)) {
+                if (!visited.get(adjTile)) {
+                    curr = prev + 1;
+                    findLongestRoadRec(adjTile, visited, curr, max);
+                }
+                max[0] = Math.max(max[0], curr);
+            }
+            visited.put(s, false); // back tracking
+
+        }
+    }
+
+
+    /**
+     * This method is to find the longest road from a route (collection with tiles)
+     * @author Frederick Li
+     * @param tilePlacements an array of tiles
+     * @param k the kind (railway or highway) : either 'r' or 'h'
+     * @return the length of the longest road
+     */
+    public static int findLongestRoad(String[] tilePlacements, char k) {
+        TileGraph tileGraph = new TileGraph(tilePlacements.length);
+
+        // initialize tile graph
+        for (String tile : tilePlacements) {
+            LinkedList<String> neighbours = new LinkedList<>();
+            tileGraph.adj.put(tile, neighbours);
+
+        }
+
+        // generate the full graph
+        for (String keyTile : tilePlacements) {
+            for (String checkingTile: tilePlacements) {
+                if (areConnectedNeighbours(keyTile,checkingTile) &&
+                        checkEdge(keyTile, checkingTile, k)) {
+                    LinkedList<String> neighbours = tileGraph.adj.get(keyTile);
+                    neighbours.add(checkingTile);
+                }
+            }
+        }
+
+        // init HashMap visited
+        HashMap<String, Boolean> visited = new HashMap<>();
+        for (String key : tilePlacements) {
+            visited.put(key, false);
+        }
+
+        ArrayList<Integer> maxCollections = new ArrayList<>();
+        for (String startTile : tilePlacements) {
+            if (tileGraph.adj.get(startTile).size() > 1) {
+                continue;   // start tile's adjacent tiles should be one
+            }
+            int[] max = {Integer.MIN_VALUE}; // an array contains the max length
+            tileGraph.findLongestRoadRec(startTile, visited,1, max); // recursively find the longest road
+            maxCollections.add(max[0]);
+
+        }
+        return maxCollections.stream().max(Comparator.comparingInt(i->i)).orElseThrow();
     }
 
+
+
     /**
      * Given the current state of a game board, output an integer representing the sum of all the factors contributing
      * to `getBasicScore`, as well as those attributed to:
      * <p>
      * * Longest railroad
      * * Longest highway
-     *
+     * @author Frederick Li
      * @param boardString a board string representing a completed game
      * @return integer (positive or negative) for final score (not counting expansion packs)
      */
     public static int getAdvancedScore(String boardString) {
         // FIXME Task 12: compute the total score including bonus points
-        return -1;
+        int basicScore = getBasicScore(boardString);
+        String[] tilePlacements = splitString(boardString, 5);
+
+        int longestRailway = findLongestRoad(tilePlacements,'r');
+        int longestHighway = findLongestRoad(tilePlacements,'h');
+
+        return longestHighway + longestRailway + basicScore;
     }
+
+
+    /**
+     * A better AI
+     * @author Frederick Li
+     * @param boardString a string represents the current game state
+     * @param diceRoll a string of diceRoll
+     * @param sTiles a List of available special tiles
+     * @return a String representing an ordered sequence of valid piece placements for the current round
+     */
+    public static String generateBetterMove(String boardString, String diceRoll,
+                                            List<String> sTiles) {
+
+        List<String> tiles = Arrays.asList(splitString(diceRoll, 2));
+
+        Collections.shuffle(tiles);
+
+        // original placed tiles
+        String[] placedTiles = splitString(boardString, 5);
+
+        HashMap<Integer, List<String>> movesCollection = new HashMap<>();
+        List<String> base = new ArrayList<>();
+        base.add(boardString);
+        movesCollection.put(-1, base); // avoid IndexOutOfBoundsException
+
+        int usedNormalTile = 0; // the number of used tiles from the diceRoll
+
+        int count = 0;  // count for tiles shifting
+        while (usedNormalTile < 4 && count < 4) {
+
+            boolean sTilesUsed = false; // can only use 1 special tile each turn
+            List<String> availableTiles = new ArrayList<>(tiles);
+            HashMap<Integer, String> scoreMove = new HashMap<>(); // moves with key(score)
+
+            if (Math.random() > 0.5) {
+                availableTiles.addAll(sTiles); // include special tiles
+            }
+
+            // start of the main loop
+            for (int i = 0; i < availableTiles.size(); i++) {
+                String tile = availableTiles.get(i);
+                if (sTilesUsed) {
+                    break;   // all the remaining tiles are special tiles
+                }
+                List<String> previousBoard = movesCollection.get(i - 1);
+                if (previousBoard == null) { continue; }
+
+                List<Character> orientations = getOrientations(tile);
+
+                for (String oldBoardString : previousBoard) {
+                    scoreMove.clear();  // init the scoreMove
+                    HashSet<String> availableGrids = getAvailableGrids(oldBoardString);
+
+                    for (String grid : availableGrids) {
+                        for (char o : orientations) {
+                            String aMove = tile + grid + o;
+                            if (isValidPlacementSequence(oldBoardString + aMove)) {
+                                if (tile.startsWith("S")) {
+                                    sTilesUsed = true;
+                                    sTiles.remove(tile);  // every special tiles can be used at most once
+                                } else {
+                                    usedNormalTile++; // increment normal tiles' count
+                                }
+
+                                String newBoardString = oldBoardString + aMove;
+                                // score based on the board (different method according to the number of placed tiles)
+                                int score = getBoardScore(grid, placedTiles.length);
+
+                                ArrayList<String> placed = new ArrayList<>();
+                                for (int j = 0; j + 5 <= oldBoardString.length(); j += 5) {
+                                    placed.add(oldBoardString.substring(j, j + 5));
+                                }
+                                ArrayList<String> adjTiles = getNeighbours(aMove, placed);
+
+                                if (!adjTiles.isEmpty()) {
+                                    score += 40; // connected to existing route
+                                } else {
+                                    score += 10;
+                                }
+                                score += countErrorsScore(newBoardString) * 15; // reduce score if there exits errors
+                                scoreMove.put(score, newBoardString);
+                            }
+                        }
+                    }
+
+                    if (!scoreMove.isEmpty()) {
+                        movesCollection.computeIfAbsent(i, k -> new ArrayList<>());
+                        List<String> currentMoves = movesCollection.get(i);
+
+                        // add the move whose score is the highest
+                        currentMoves.add(scoreMove.get(Collections.max(scoreMove.keySet())));
+                    }
+                }
+
+            }
+
+            if (usedNormalTile < 4) {
+                tiles.add(tiles.remove(0)); // shift rotate the tiles
+                movesCollection.clear();
+                movesCollection.put(-1, base);
+                count++;
+            }
+
+        }
+
+        int finalScore = Integer.MIN_VALUE;
+        String returnMove = "";
+        // get the most recent moves collection
+        List<String> moves = movesCollection.get(Collections.max(movesCollection.keySet()));
+
+        for (String move: moves) {
+            int currScore = getAdvancedScore(move);
+            if (currScore > finalScore) {
+                returnMove = move.substring(boardString.length());
+                finalScore = currScore;
+            }
+        }
+        return  returnMove;
+    }
+
+    private static int getBoardScore(String grid, int placedTile) {
+        int[][] boardScore = {{10, 10, 10, 10, 10, 10, 10},
+                            {10, 20, 20, 20, 20, 20, 10},
+                            {10, 20, 50, 50, 50, 20, 10},
+                            {10, 20, 50, 50, 50, 20, 10},
+                            {10, 20, 50, 50, 50, 20, 10},
+                            {10, 20, 20, 20, 20, 20, 10},
+                            {10, 10, 10, 10, 10, 10, 10}};
+
+        if (placedTile < 20) {
+            return boardScore[grid.charAt(0) - 'A'][grid.charAt(1) - '0'];
+        } else {
+            return 60 - boardScore[grid.charAt(0) - 'A'][grid.charAt(1) - '0'];
+        }
+    }
+
+
+
 }
 
+
+
Only in comp1110-ass2/src/comp1110/ass2: RailroadInk$TileGraph.class
Only in comp1110-ass2/src: gittest
Only in comp1110-ass2/src: META-INF
Only in comp1110-ass2/src: skeleton
Only in comp1110-ass2/tests: mytest
```
## Test log
```
--javac output--
----
JUnit version 4.12
...
Time: 0.063

OK (3 tests)

JUnit version 4.12
......
Time: 0.054

OK (6 tests)

JUnit version 4.12
.....
Time: 0.043

OK (5 tests)

JUnit version 4.12
.....
Time: 0.118

OK (5 tests)

JUnit version 4.12
....
Time: 0.121

OK (4 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score 24
Sample game A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41
score 18
Sample game A2A30A0A43A3A50B2B50A4C50A3D50A2B43B0G12B0A14A2B33A0B11A4E50A3D61A2B21A3G52B1G45A3F52B2F41A3F33A1E40A1D40A3E32A3E27B0F10S0E12B1D17A4D01A1B61A0C43
score 21
Sample game A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11
score 15
Sample game A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02
score 23
Sample game A4G10B2F10A4E10A0F20A3D17A0E22A2E31B1E44S0D42A3D23A4D31A2F30B1F42A1G30A0C42A0C57B0C22A2F03A1E02S5D01A0B22B0A50A4D51A3D61B2B53A0B30B2A31A4E60A3A41A0B03
score 23
Sample game A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00
score 26
Sample game A0B06A5A50A5A42A3B44A3C42A3D44B2D35B2C37A0B33A2B27A2E35B2C27A4C13A5C05A1F01B2D21A1F15A5D04A4D11A2E20B1B10A4A10S4E44A3E55A2F25S3F40B2F30A3D50A4D67
score 13
Sample game B2A37A3A43A3A54A3A21A5A14B2B20A0B30A4C20A1B17A2B07B2D05A0E04A1C00B0G16A0F13A0G32B2D11A5D20A0E10A5B51B2G46A4F40A5E42A0C15B1G52A5E50A1F03A2F63
score 18
Sample game A1A30A3D05A3C06B0B06A3C13A3C27B2C33A1B30B0D32A5E30A0A02A2A11S4E24S2D20A4D15B0B16A1E17A0E02A3C43A4B40A3A47A5A50A3C57B0D50A0E51A0E63A0F64
score 13
...
Time: 0.068

OK (4 tests)

JUnit version 4.12
.....
Time: 0.161

OK (5 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score 41
Sample game A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41
score 36
Sample game A2A30A0A43A3A50B2B50A4C50A3D50A2B43B0G12B0A14A2B33A0B11A4E50A3D61A2B21A3G52B1G45A3F52B2F41A3F33A1E40A1D40A3E32A3E27B0F10S0E12B1D17A4D01A1B61A0C43
score 42
Sample game A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11
score 32
Sample game A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02
score 42
Sample game A4G10B2F10A4E10A0F20A3D17A0E22A2E31B1E44S0D42A3D23A4D31A2F30B1F42A1G30A0C42A0C57B0C22A2F03A1E02S5D01A0B22B0A50A4D51A3D61B2B53A0B30B2A31A4E60A3A41A0B03
score 42
Sample game A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00
score 41
Sample game A0B06A5A50A5A42A3B44A3C42A3D44B2D35B2C37A0B33A2B27A2E35B2C27A4C13A5C05A1F01B2D21A1F15A5D04A4D11A2E20B1B10A4A10S4E44A3E55A2F25S3F40B2F30A3D50A4D67
score 44
Sample game B2A37A3A43A3A54A3A21A5A14B2B20A0B30A4C20A1B17A2B07B2D05A0E04A1C00B0G16A0F13A0G32B2D11A5D20A0E10A5B51B2G46A4F40A5E42A0C15B1G52A5E50A1F03A2F63
score 39
Sample game A1A30A3D05A3C06B0B06A3C13A3C27B2C33A1B30B0D32A5E30A0A02A2A11S4E24S2D20A4D15B0B16A1E17A0E02A3C43A4B40A3A47A5A50A3C57B0D50A0E51A0E63A0F64
score 31
.
Time: 0.074

OK (2 tests)

```
