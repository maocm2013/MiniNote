package com.malcolm.note.domain;

/**
 *
 * @author user
 */
public class NoteInfo {
    private String pkId;
    private String noteName;
    private String noteComment;
    private String deadLineDate;
    private String priority;
    private String noteState;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteComment() {
        return noteComment;
    }

    public void setNoteComment(String noteComment) {
        this.noteComment = noteComment;
    }

    public String getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(String deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNoteState() {
        return noteState;
    }

    public void setNoteState(String noteState) {
        this.noteState = noteState;
    }

    @Override
    public String toString() {
        return "NoteInfo{" + "pkId=" + pkId + ", noteName=" + noteName + ", noteComment=" + noteComment + ", deadLineDate=" + deadLineDate + ", priority=" + priority + ", noteState=" + noteState + '}';
    }
    
    
}
