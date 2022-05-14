package com.moodverse.appResource;

public enum Magic8Ball {
    CERTAIN(1), DEFINITELY(2), YES(3), MOST_LIKELY(4), BETTER_NOT_TELL_YOU(5), ASK_LATER(6), DOUBTFUL(7), NO(8);

    private int index;

    private Magic8Ball(int i) {
        index = i;
    }

}
