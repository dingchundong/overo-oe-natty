# NOTE! This is an update file and will go away when upstream updates
# TODO: send this to upstream

DESCRIPTION = "GNOME XML Parser library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r4"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--without-python --without-debug --without-legacy --without-catalog --without-docbook --with-c14n"

export LDFLAGS += "-ldl"

do_stage() {
	autotools_stage_all
	install -m 0644 libxml.m4 ${STAGING_DATADIR}/aclocal/
        #this is need it by php during its install
        install -m 0755 xml2-config ${STAGING_BINDIR}
}

python populate_packages_prepend () {
	# autonamer would call this libxml2-2, but we don't want that
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		bb.data.setVar('PKG_libxml2', 'libxml2', d)
}

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-utils ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-utils += "${bindir}/*"