package com.epam.task3.controller.command;

/**
 * enum for any command,which user can call
 */
public enum CommandName {
    /**
     * NOTE: this tag count will be used to prevent code copies in the service and dao layers
     * value of the tag should be putted according to the order in the file
     * -1 if command doesn't execute searching by tag
     */
    ADDNEWS(-1), CATEGORY(0), TITLE(1), NAME(2), WRONG_REQUEST(-1);
    private int tagCount;

    private CommandName(int tagCount) {
        this.tagCount = tagCount;
    }
    public int getTagCount() {
        return tagCount;
    }
};