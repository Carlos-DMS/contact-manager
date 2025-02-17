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

    private final String tipoContatoRelatorio;

    TipoContato(String tipoContatoRelatorio) {
        this.tipoContatoRelatorio = tipoContatoRelatorio;
    }

    public String getTipoContatoRelatorio() {
        return tipoContatoRelatorio;
    }
}
