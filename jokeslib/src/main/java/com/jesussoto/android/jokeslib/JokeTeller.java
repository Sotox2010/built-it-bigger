package com.jesussoto.android.jokeslib;

import java.util.Random;

public class JokeTeller {

    public static String tellRandomJoke() {
        int index = new Random().nextInt(JOKES.length);
        return JOKES[index];
    }

    private static final String[] JOKES = new String[] {
        "<p><b>Q:</b> How do you know if a dummy has been sending email?</p> <p><b>A:</b> There are a bunch of envelopes stuffed into the disk drive.</p>",
        "<b>Knock, knock!</b><br/>Who's there?<br/>Dummy.<br/>Dummy who?<br/>Dummy a favour and get lost!<br/>",
        "<p>Did you hear about the claustrophobic astronaut?</p><p>He just needed a little space.</p>",
        "<p>Why don't scientists trust atoms?</p><p>Because they make up everything.</p>",
        "<p>How do you drown a hipster?</p><p>Throw him in the mainstream.</p>",
        "<p>What did the Buddhist say to the hot dog vendor?</p><p>Make me one with everything.</p>",
        "<p>What do you call a fake noodle?</p><p>An impasta!</p>",
        "<p>What did the shark say when he ate the clownfish?</p><p>This tastes a little funny.</p>",
        "<p>What is an astronaut's favorite part on a computer?</p><p>The space bar.</p>",
        "<p>Did you hear about the two people who stole a calendar?</p><p>They each got six months.</p>",
        "<p>Where does Batman go to the bathroom?</p><p>The batroom.</p>",
        "<p>Why did the Oreo go to the dentist?</p><p>Because he lost his filling.</p>",
        "<p>What breed of dog can jump higher than buildings?</p><p>Any dog, because buildings can't jump.</p>",
        "<p>Why aren't koalas actual bears?</p><p>They don't meet the koalafications.</p>",
        "<p>Rest in peace to boiling water.</p><p>You will be mist.</p>",
        "<p>What do you call a train carrying bubblegum?</p><p>A chew-chew train.</p>",
        "<p>What's the best thing about Switzerland?</p><p>I don't know, but the flag is a big plus.</p>",
        "<p>Hear about the new restaurant called Karma?</p><p>There's no menu: You get what you deserve.</p>",
        "<p>A man tells his doctor, \"Doc, help me. I'm addicted to Twitter!</p><p>The doctor replies, \"Sorry, I don't follow you ...\"</p>"
    };
}
