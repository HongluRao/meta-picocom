SUMMARY = "libnetconf2 is a NETCONF library in C intended for building NETCONF clients and servers"
DESCRIPTION = "The library handles NETCONF authentication and all NETCONF RPC communication both server and client-side."
SECTION = "libs"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=08a5578c9bab06fb2ae84284630b973f"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit cmake pkgconfig

SRCREV = "47ca0fb5f94588d112ec2bf26946948189e1c18d"
SRC_URI = "git://github.com/CESNET/libnetconf2.git;protocol=https;branch=devel"

PV = "3.3.3+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "libssh libpam openssl libyang libxcrypt curl"

FILES:${PN} += "/usr/share/yang/*"
