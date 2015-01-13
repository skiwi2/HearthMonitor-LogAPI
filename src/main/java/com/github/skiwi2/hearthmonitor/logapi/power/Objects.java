package com.github.skiwi2.hearthmonitor.logapi.power;

/**
 * Utility class used to mimic used JDK 7 Objects behaviour.
 *
 * @author Frank van Heeswijk
 */
final class Objects {
    private Objects() {
        throw new UnsupportedOperationException();
    }

    /**
     * Tests whether the given object is null.
     *
     * @param object    The given object
     * @param message   The message of the NullPointerException if object is null
     * @param <T>   The type of object
     * @return  The object if it is not null.
     * @throws  java.lang.NullPointerException  If object is null.
     */
    static <T> T requireNonNull(final T object, final String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }
}
