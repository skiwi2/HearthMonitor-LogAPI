package com.github.skiwi2.hearthmonitor.logapi;

/**
 * Marker interface to denote that a class can be used as an log entry.
 *
 * A log entry always ranges over at least one full line of the log file, and thus is also a log object.
 *
 * @author Frank van Heeswijk
 */
public interface LogEntry extends LogObject { }
