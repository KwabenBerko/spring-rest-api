package tasky.models;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID uuid;
    private String name, createdAt;
    private boolean completed;

    private Task(Builder builder){
        this.uuid = builder.uuid;
        this.name = builder.name;
        this.completed = builder.completed;
        this.createdAt = builder.createdAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static class Builder{
        private UUID uuid;
        private String name, createdAt;
        private boolean completed;

        public Builder uuid(UUID uuid){
            this.uuid = uuid;
            return this;
        }

        public Builder title(String name){
            this.name = name;
            return this;
        }

        public Builder completed(boolean completed){
            this.completed = completed;
            return this;
        }


        public Builder createdAt(String createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }
}
