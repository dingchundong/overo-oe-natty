DESCRIPTION = "Sugar base system"
LICENSE = "LGPLv2"

PR = "r2"

DEPENDS = "python-pygtk sugar-toolkit"
RDEPENDS_${PN} = "librsvg-gtk \
            ohm-plugin-x11 ohm \
	    hippo-canvas \
            python-datetime \
            python-netclient \
	    python-pygtk \
	    sugar-toolkit \
	    python-logging \
	    python-dbus \
	    python-subprocess \
	    telepathy-gabble telepathy-salut telepathy-python \
	    sugar-presence-service \
	    python-crypt \
	    python-numpy \
	    python-compression \
	    python-gst \
	    python-simplejson \
	    python-misc \
	    python-xmlrpc \
	    python-compiler \
	    python-pydoc \
	    python-mmap \
	    python-doctest \
	    ssh-keygen"

inherit gnome distutils-base

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-base/${PN}-${PV}.tar.bz2"

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

FILES_${PN} += "${datadir}/${PN} \
		${datadir}/dbus-1 \
		${sysconfdir} "

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/sugar/.debug"

SRC_URI[md5sum] = "0f05d95eaf0f8e3174a3b3e3b0afe995"
SRC_URI[sha256sum] = "64ece8bb8e6eddb4c7b8b4ce0aa30f07f00a86ed7b113a7957661e73616a8dc3"
