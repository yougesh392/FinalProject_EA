package com.miu.MainApplication.DTO;

import java.time.LocalDateTime;


public class CommentDTO {
        private Long id;
        private String text;
        private LocalDateTime date;

        public CommentDTO(Long id, String text, LocalDateTime date) {
                this.id = id;
                this.text = text;
                this.date = date;
        }

        public CommentDTO() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public LocalDateTime getDate() {
                return date;
        }

        public void setDate(LocalDateTime date) {
                this.date = date;
        }
}
