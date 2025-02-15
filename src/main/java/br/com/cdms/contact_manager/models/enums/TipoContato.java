package br.com.cdms.contact_manager.models.enums;

public enum TipoContato {
    EMAIL("email"),
    CELULAR("celular"),
    WHATSAPP("Whatsapp"),
    TELEGRAM("Telegram"),
    SKYPE("Skype"),
    DISCORD("Discord"),
    MICROSOFT_TEAMS("Microsoft Teams"),
    LINKEDIN("LinkedIn"),
    GITHUB("GitHub");

    private final String contatoRelatorio;

    TipoContato(String contatoRelatorio) {
        this.contatoRelatorio = contatoRelatorio;
    }

    public String getContatoRelatorio() {
        return contatoRelatorio;
    }
}
